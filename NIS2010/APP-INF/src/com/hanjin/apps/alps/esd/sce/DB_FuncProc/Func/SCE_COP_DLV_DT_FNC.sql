CREATE OR REPLACE FUNCTION SCE_COP_DLV_DT_FNC (
                                p_cop_no        IN  VARCHAR2,
                                p_bkg_no        IN  VARCHAR2)
/*******************************************************************************
   1. Object Name      : SCE_COP_DLV_DT_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.08.28
   4. Sub System       : SCE
   5. Author           : 김인수
   6. Description      : Booking Delivery Term 별 Plan / Estimated date 를 조회
            1. Door, Tackle, Free-Out term
                : Empty return 이전 시점 (FITZAD, FUVMUD 등) 
            2. CFS term
                : CFS 도착 시점
            3. 그 이외 (Mixed, Yard, Free In 등)
                : 양하 시점
   7. Revision History : 
*******************************************************************************/                                
                               
RETURN VARCHAR2
AUTHID CURRENT_USER   

IS 
  r_dlv_pln_date    VARCHAR2(18):='' ;
  r_dlv_estm_date   VARCHAR2(18):='' ;
  r_de_term_cd      VARCHAR2(1):='' ;
  r_result          VARCHAR2(47) :='' ;

                                                        
BEGIN

  SELECT  de_term_cd
  INTO    r_de_term_cd
  FROM    bkg_booking
  WHERE   bkg_no       = p_bkg_no
  ;

      IF r_de_term_cd IN ('D','T','O') THEN
      
        SELECT  TO_CHAR(MAX(pln_dt),'yyyy-MM-dd hh24:mi'),
                TO_CHAR(MAX(estm_dt),'yyyy-MM-dd hh24:mi')
        INTO    r_dlv_pln_date,
                r_dlv_estm_date        
        FROM    (
                SELECT  LEAD(pln_dt, 1) OVER (PARTITION BY cop_no ORDER BY cop_no, cop_dtl_seq desc) pln_dt,
                        LEAD(estm_dt, 1) OVER (PARTITION BY cop_no ORDER BY cop_no, cop_dtl_seq desc) estm_dt
                FROM    sce_cop_dtl
                WHERE   cop_no = p_cop_no)
        WHERE   rownum = 1;    
        
       ELSIF r_de_term_cd = 'S' THEN
       
        SELECT  TO_CHAR(MAX(pln_dt),'yyyy-MM-dd hh24:mi'),
                TO_CHAR(MAX(estm_dt),'yyyy-MM-dd hh24:mi')
        INTO    r_dlv_pln_date,
                r_dlv_estm_date        
        FROM    (
                SELECT  LEAD(pln_dt, 0) OVER (PARTITION BY cop_no ORDER BY cop_no, cop_dtl_seq desc) pln_dt,
                        LEAD(estm_dt, 0) OVER (PARTITION BY cop_no ORDER BY cop_no, cop_dtl_seq desc) estm_dt
                FROM    sce_cop_dtl
                WHERE   cop_no = p_cop_no) 
        WHERE   rownum = 1;   
    
      ELSE
    
        SELECT  TO_CHAR(MAX(pln_dt),'yyyy-MM-dd hh24:mi'),
                TO_CHAR(MAX(estm_dt),'yyyy-MM-dd hh24:mi')
        INTO    r_dlv_pln_date,
                r_dlv_estm_date        
        FROM    (
                SELECT  LEAD(pln_dt, 2) OVER (PARTITION BY cop_no ORDER BY cop_no, cop_dtl_seq desc) pln_dt,
                        LEAD(estm_dt, 2) OVER (PARTITION BY cop_no ORDER BY cop_no, cop_dtl_seq desc) estm_dt
                FROM    sce_cop_dtl
                WHERE   cop_no = p_cop_no) 
        WHERE   rownum = 1;  
    
    
     END IF ;

  
  r_result := r_dlv_pln_date || '#' || r_dlv_estm_date ;

  --DBMS_OUTPUT.PUT_LINE('처리종료-'||r_result);              
    
  RETURN r_result ; 
END ;
/
