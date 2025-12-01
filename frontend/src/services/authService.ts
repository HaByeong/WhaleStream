import apiClient from '../utils/api';

export interface LoginRequest {
  userId: string; // 백엔드가 userId로 로그인하므로 변경
  password: string;
}

export interface LoginResponse {
  accessToken: string;
  refreshToken: string;
  userId: string;
}

export const authService = {
  login: async (credentials: LoginRequest): Promise<LoginResponse> => {
    // 데모 계정 처리 (백엔드 구현 전까지)
    if (credentials.userId === 'demo' && credentials.password === 'demo123') {
      const demoToken = 'demo-access-token-' + Date.now();
      const demoRefreshToken = 'demo-refresh-token-' + Date.now();
      
      localStorage.setItem('accessToken', demoToken);
      localStorage.setItem('refreshToken', demoRefreshToken);
      localStorage.setItem('userId', 'demo');
      
      return {
        accessToken: demoToken,
        refreshToken: demoRefreshToken,
        userId: 'demo',
      };
    }

    // 실제 백엔드 API 호출
    try {
      const response = await apiClient.post('/auth/login', credentials);
      const { accessToken, refreshToken, userId } = response.data;
      
      // 토큰 저장
      localStorage.setItem('accessToken', accessToken);
      localStorage.setItem('refreshToken', refreshToken);
      localStorage.setItem('userId', userId);
      
      return { accessToken, refreshToken, userId };
    } catch (error: any) {
      // 네트워크 에러나 404 에러 시 데모 모드로 처리
      if (error.code === 'ERR_NETWORK' || error.response?.status === 404) {
        if (credentials.userId === 'demo' && credentials.password === 'demo123') {
          const demoToken = 'demo-access-token-' + Date.now();
          const demoRefreshToken = 'demo-refresh-token-' + Date.now();
          
          localStorage.setItem('accessToken', demoToken);
          localStorage.setItem('refreshToken', demoRefreshToken);
          localStorage.setItem('userId', 'demo');
          
          return {
            accessToken: demoToken,
            refreshToken: demoRefreshToken,
            userId: 'demo',
          };
        }
      }
      throw error;
    }
  },

  logout: () => {
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
    localStorage.removeItem('userId');
  },

  isAuthenticated: (): boolean => {
    return !!localStorage.getItem('accessToken');
  },

  getCurrentUserId: (): string | null => {
    return localStorage.getItem('userId');
  },
};

