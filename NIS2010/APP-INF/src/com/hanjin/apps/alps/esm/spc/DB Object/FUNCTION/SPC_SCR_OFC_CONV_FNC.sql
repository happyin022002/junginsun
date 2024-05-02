CREATE OR REPLACE FUNCTION NISADM.SPC_SCR_OFC_CONV_FNC ( v_ofc_cd IN VARCHAR2, v_ui_no IN VARCHAR2 := NULL)
                                                                                                          
RETURN VARCHAR2                                                                                           
authid current_user                                                                                       
                                                                                                          
IS                                                                                                        
/******************************************************************************                           
   Name         :   SPC_SCR_OFC_CONV_FNC                                                                    
   Purpose      :   UI 별로 Security 관련하여 필요 Office 를 Conversion 하는 Function                     
   Table        :   non                                                                                   
   System       :   e-NIS > YMS > SPC                                                                     
   History      :   Ver 1.0 서관영 2008.06.02                                                             
                    2008.09.05                                                                            
                    CSRNO:N200809090009 임옥영                                                            
                    - 'QT'타입에 대한 처리                                                                
                    2009.01.28                                                                            
                    CSRNO:N200901230010 최윤성                                                            
                    - 'SINRSS', 'SINRSO' 대하여 Conversion Office를 'SELCDO'로 변경                       
                    2009.08.03                                                                            
                    CSRNO:N200907290060 최윤성                                                            
                    - 'ATLSA' 대하여 화면 'ESM_SPC_021' 권한을 'NYCRA'로 변경     
                    2010.05.19
                    -- CSR 에 의해 'NYCRAS'의 정보를 'BB' 변경했기에 제외시킴
                    2011.03.24
                    SR No : SRM-201114634 김수정
                    - TPEBA Office 삭제에 의해 TPESC를 TPEBA로 변경하는 로직 제거
                    SR No : SRM-201118040 김수정
                    - DACBA/MGLBA/CGPBA -> DACSC로 변경
                    CSR No : CHM-201113896 김수정
                    - 'ISTBA' 대하여 화면 'ESM_SPC_021' 권한을 'ISTSC'로 변경
                    SR No : SRM-201228507 김수정
                    - 'SELCTA/CTE/CTI' 대하여 화면 'ESM_SPC_021' 권한을 'SELCDO'로 변경
                    2012.10.12 김수정
                    - ATLSA 예외처리 => ATLSA
                    2013.06.17 김시몬
                    - 조직개편에 따른 SELCDO => SELCTY 로 변경, 'SELCMU', 'SELCMA' 추가
                    2013.07.15 김시몬
                    - 조직개편에 따른 JEDBA,KWIBA,OMNBA,BAHBA => DXBSC 로 변경 추가
                    2013.07.16 김시몬
                    - S.REP소속 변경에 따른 MNLBA => MNLSC 로 변경 추가
                    2013.07.17 김시몬
                    - DXBSC에 대한 예외처리를 UI별로 변경
                    2013.07.18 진마리아
                    - DXBSC 산하에 OFC 추가 ('AISBA','DURBA','MBABA','DARBA')
                    2013.11.05 진마리아
                    - HAMRUC,NYCRAC,SINRSC 에 대해 RHQ 권한으로 예외처리
                    2014.07.04 김시몬
                    - DXBSC 산하에 OFC 추가 ('DOHBA','DMNBA','IRQBA','JORBA','THRBA'')
                    2014.12.01 임옥영 SRM-201449200 인도지역 신규 Sub Agency, Office Code 생성에 따른 각 시스템 적용 요청
                    - BOMSC 산하에 OFC 변경('TUTBS', 'BLRBS' --> 'TUTBA', 'BLRBA')
******************************************************************************/                           
                                                                                                          
    v_rtn_ofc_cd VARCHAR2(7);                                                                             
                                                                                                          
BEGIN               
    -- 공통 Conversion Rule                                                                               
    CASE v_ofc_cd                                                                                         
    WHEN 'JKTSC' THEN                                                                                     
        v_rtn_ofc_cd := 'JKTBA';                                                                          
    WHEN 'MNLBA' THEN                                                                                     
        v_rtn_ofc_cd := 'MNLSC';                                                                          
    --WHEN 'TPESC' THEN                                                                                     
    --    v_rtn_ofc_cd := 'TPEBA';                                                                          
    WHEN 'PHXSA' THEN                                                                                     
        v_rtn_ofc_cd := 'LGBSC';                                                                          
    WHEN 'PKGSA' THEN                                                                                     
        v_rtn_ofc_cd := 'PKGSA';                                                                          
    WHEN 'SELSA' THEN                                                                                     
        v_rtn_ofc_cd := 'SELSA';                                                                          
    WHEN 'SLCSC' THEN                                                                                     
        v_rtn_ofc_cd := 'SEASC';                                                                             
    WHEN 'DACBA' THEN                                                                                     
        v_rtn_ofc_cd := 'DACSC';                                                                                 
    WHEN 'MGLBA' THEN                                                                                     
        v_rtn_ofc_cd := 'DACSC';                                                                              
    WHEN 'CGPBA' THEN                                                                                     
        v_rtn_ofc_cd := 'DACSC'; 
    
    -- ATLSA 예외처리 : ATLSA                                                                        
    WHEN 'ATLSA' THEN                                                                                     
        v_rtn_ofc_cd := 'ATLSA'; 
        
    -- JEDBA,KWIBA,OMNBA,BAHBA 예외처리 : DXBSC                                                                        
--    WHEN 'JEDBA' THEN                                                                                     
--        v_rtn_ofc_cd := 'DXBSC'; 
--    WHEN 'KWIBA' THEN                                                                                     
--        v_rtn_ofc_cd := 'DXBSC'; 
--    WHEN 'OMNBA' THEN                                                                                     
--        v_rtn_ofc_cd := 'DXBSC'; 
--    WHEN 'BAHBA' THEN                                                                                     
--        v_rtn_ofc_cd := 'DXBSC';     
    WHEN 'TUTBS' THEN                                                                                     
        v_rtn_ofc_cd := 'TUTBA'; 
        
    WHEN 'BLRBS' THEN                                                                                     
        v_rtn_ofc_cd := 'BLRBA'; 
        
    ELSE                                                                                                  
        v_rtn_ofc_cd := v_ofc_cd;                                                                         
    END CASE;                                                                                             
                                                                                                          
    --지역본부내 팀에 대한 Conversion                                                                     
    CASE v_ofc_cd                                                                                         
    WHEN 'HAMRUG' THEN                                                                                    
        v_rtn_ofc_cd := 'HAMRU';                                                                          
    WHEN 'HAMRUO' THEN                                                                                    
        v_rtn_ofc_cd := 'HAMRU';                                                                          
    WHEN 'HAMRUS' THEN                                                                                    
        v_rtn_ofc_cd := 'HAMRU';                                                                          
    WHEN 'HAMUXG' THEN                                                                                    
        v_rtn_ofc_cd := 'HAMRU';                                                                          
    WHEN 'HAMRUC' THEN                                                                                    
        v_rtn_ofc_cd := 'HAMRU';                                                                          
    WHEN 'NYCRAG' THEN                                                                                    
        v_rtn_ofc_cd := 'NYCRA';                                                                          
    WHEN 'NYCRAO' THEN                                                                                    
        v_rtn_ofc_cd := 'NYCRA';                                                                          
    --WHEN 'NYCRAS' THEN                                                                                    
    --    v_rtn_ofc_cd := 'NYCRA';                                                                          
    WHEN 'NYCRAX' THEN                                                                                    
        v_rtn_ofc_cd := 'NYCRA';
    WHEN 'NYCRAC' THEN
        v_rtn_ofc_cd := 'NYCRA';
    WHEN 'SHARCG' THEN                                                                                    
        v_rtn_ofc_cd := 'SHARC';                                                                          
    WHEN 'SHAADG' THEN                                                                                    
        v_rtn_ofc_cd := 'SHARC';                                                                          
    WHEN 'SHAALG' THEN                                                                                    
        v_rtn_ofc_cd := 'SHARC';                                                                          
    WHEN 'SHARCO' THEN                                                                                    
        v_rtn_ofc_cd := 'SHARC';                                                                          
    WHEN 'SHARCG' THEN                                                                                    
        v_rtn_ofc_cd := 'SHARC';                                                                          
    WHEN 'SINRSG' THEN                                                                                    
        v_rtn_ofc_cd := 'SINRS';                                                                          
    WHEN 'SINRSS' THEN                                                                                    
        v_rtn_ofc_cd := 'SELCTY';                                                                         
    WHEN 'SINRSO' THEN                                                                                    
        v_rtn_ofc_cd := 'SELCTY';                                                                         
    WHEN 'SINRSC' THEN
        v_rtn_ofc_cd := 'SINRS';
    ELSE                                                                                                  
        v_rtn_ofc_cd := v_rtn_ofc_cd;                                                                     
    END CASE;                                                                                             
                                                                                                          
                                                                                                     
    -- UI 별 Conversion                                                                                   
    IF  v_ui_no = 'EsmSpc0021' THEN -- Daily Forecast Status                                             
        IF v_ofc_cd IN ('SLCSC','PHXSA','ATLSA','NYCRAS') THEN       
            v_rtn_ofc_cd := 'NYCRA';      
        ELSIF v_ofc_cd = 'ISTBA' THEN                                                      
            v_rtn_ofc_cd := 'ISTSC';        
        ELSIF v_ofc_cd IN ('SELCTI', 'SELCTA', 'SELCTE','SELCMU', 'SELCMA') THEN                                                      
            v_rtn_ofc_cd := 'SELCTY';         
        END IF;                                                                                           
    ELSIF  v_ui_no IN ('EsmSpc0022', 'EsmSpc0102') THEN
       IF v_ofc_cd IN ('JEDBA', 'KWIBA', 'OMNBA', 'BAHBA', 'AISBA','DURBA','MBABA','DARBA','DOHBA','DMNBA','IRQBA','JORBA','THRBA') THEN                                                      
            v_rtn_ofc_cd := 'DXBSC';  
       END IF;
    END IF;                                                                                               
                                                                                                          
    RETURN v_rtn_ofc_cd;                                                                                  
END ;
