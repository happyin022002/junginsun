CREATE OR REPLACE FUNCTION SCE_COP_TOT_TRAN_TIME_FNC 
                                    (p_cop_no         IN    VARCHAR2,
                                     p_bkg_no         IN    VARCHAR2)
/*******************************************************************************
   1. Object Name      : SCE_COP_TOT_TRAN_TIME_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.09.18
   4. Sub System       : SCE
   5. Author           : ������
   6. Description      : total transit time ����
   7. Revision History : 2009.09.18 NIS2010 �� ���� revision
                         2010.06.03 ISKIM : 
                          (-) �� ���� ���� ��� mvmt �� �����Ͽ� �� ����(COA ��û ���� follow up)
                         2010.06.30 YJLEE : (-) ���� ���� �߰�
                          1. Bound �� MVMT ���� ����. ������ Min/Max Actual ����.
                          2. MVMT Date GMT ����
                          3. RCV DT�� MVMT Data �� ���� �Ŀ��� (-) ���� �� DLV DT �� MVMT Data�� ����.
                         2011.03.06 Poong Yeon Cho
                          1.BST�� �ǰ� ���� GLOBALDATE_PKG.TIME_CONV_FNC�� �ڵ��� ���̵��� ����.
                          2.��Ÿ �ʿ���� ���� �� ������ ����, �ּ� ����, ���ǹ� �������� �ҽ� LINE�� ����ȭ
*******************************************************************************/

RETURN VARCHAR2

authid current_user 

IS 
  r_rcv_term_cd     VARCHAR2(1):='' ; 
  r_de_term_cd      VARCHAR2(1):='' ; 

  r_dlv_pln_dt      DATE ;
  r_dlv_estm_dt     DATE ;
  
  r_rcv_pln_dt      DATE ;
  r_rcv_estm_dt     DATE ;
  
  r_dlv_act_dt      DATE:= null ;
  r_rcv_act_dt      DATE:= null ;
  
  r_cal_dlv_pln_dt      DATE ;
  r_cal_dlv_estm_dt     DATE ;
  
  r_cal_rcv_pln_dt      DATE ;
  r_cal_rcv_estm_dt     DATE ;

  r_tot_tran_pln_dt   VARCHAR2(14):='' ;
  r_tot_tran_estm_dt  VARCHAR2(14):='' ;
  
  lead_num number ;
  
  temp_r_nod VARCHAR2(5);
  temp_d_nod VARCHAR2(5);
  
  temp_r_pln_dt DATE;
  temp_r_est_dt DATE;
  
  temp_d_pln_dt DATE;
  temp_d_est_dt DATE;
  
  r_result          VARCHAR2(30) :='' ;
                                                        
BEGIN
  SELECT  rcv_term_cd,
          de_term_cd
  INTO    r_rcv_term_cd,
          r_de_term_cd
  FROM    bkg_booking
  WHERE   bkg_no       = p_bkg_no;

/* Receiving Term */
    IF r_rcv_term_cd = 'S' THEN
        lead_num := 0;
    ELSE
        lead_num := 1;
    END IF;
      
        SELECT  SUBSTR(nod_cd,1,5), pln_dt, estm_dt
        INTO    temp_r_nod,
                temp_r_pln_dt,
                temp_r_est_dt
        FROM    (
                SELECT  
                        LEAD(pln_dt,  lead_num) OVER (PARTITION BY cop_no ORDER BY cop_no,cop_dtl_seq) pln_dt,
                        LEAD(estm_dt, lead_num) OVER (PARTITION BY cop_no ORDER BY cop_no,cop_dtl_seq) estm_dt,
                        LEAD(nod_cd,  lead_num) OVER (PARTITION BY cop_no ORDER BY cop_no,cop_dtl_seq) nod_cd
                FROM    sce_cop_dtl
                WHERE   cop_no = p_cop_no) 
        where rownum =1;     
     
/* Delivery Term */
    IF r_de_term_cd IN ('D','T','O') THEN
        lead_num := 1;
    ELSIF r_de_term_cd = 'S' THEN
        lead_num := 0;
    ELSE
        lead_num := 2;
    END IF;  
        
        SELECT  SUBSTR(nod_cd,1,5), pln_dt, estm_dt
        INTO    temp_d_nod,
                temp_d_pln_dt,
                temp_d_est_dt
        FROM    (
                SELECT
                        LEAD(pln_dt,  lead_num) OVER (PARTITION BY cop_no ORDER BY cop_no desc,cop_dtl_seq desc) pln_dt,
                        LEAD(estm_dt, lead_num) OVER (PARTITION BY cop_no ORDER BY cop_no desc,cop_dtl_seq desc) estm_dt,
                        LEAD(nod_cd,  lead_num) OVER (PARTITION BY cop_no ORDER BY cop_no desc,cop_dtl_seq desc) nod_cd                                        
                FROM    sce_cop_dtl
                WHERE   cop_no = p_cop_no
                ) 
        where rownum =1;

  r_rcv_pln_dt := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(temp_r_nod,1,5), temp_r_pln_dt, 'GMT');
  r_rcv_estm_dt := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(temp_r_nod,1,5), temp_r_est_dt, 'GMT');
  r_dlv_pln_dt := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(temp_d_nod,1,5), temp_d_pln_dt, 'GMT');
  r_dlv_estm_dt := GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(temp_d_nod,1,5), temp_d_est_dt, 'GMT');
     
  r_cal_dlv_pln_dt := r_dlv_pln_dt;
  r_cal_dlv_estm_dt := r_dlv_estm_dt;
  
  r_cal_rcv_pln_dt := r_rcv_pln_dt;
  r_cal_rcv_estm_dt := r_rcv_estm_dt;
     
    SELECT MIN(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(ORG_YD_CD,1,5), CNMV_EVNT_DT, 'GMT') ),
           MAX(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(ORG_YD_CD,1,5), CNMV_EVNT_DT, 'GMT') )    
    INTO r_rcv_act_dt, r_dlv_act_dt
    FROM CTM_MOVEMENT 
    WHERE (BKG_NO, CNTR_NO) IN (SELECT BKG_NO, CNTR_NO FROM SCE_COP_HDR WHERE COP_NO = p_cop_no)
    ;
     
  IF (r_dlv_pln_dt  - r_rcv_pln_dt) < 0 AND r_rcv_act_dt IS NOT NULL  THEN
    r_cal_rcv_pln_dt := r_rcv_act_dt;
  
  END IF;  
  
  IF (r_dlv_estm_dt  - r_rcv_estm_dt) < 0 AND r_rcv_act_dt IS NOT NULL THEN
    r_cal_rcv_estm_dt := r_rcv_act_dt;
  
  END IF;
  
  IF (r_cal_dlv_pln_dt  - r_cal_rcv_pln_dt) < 0 AND r_dlv_act_dt IS NOT NULL  THEN
    r_cal_dlv_pln_dt := r_dlv_act_dt;
    r_cal_rcv_pln_dt := r_rcv_act_dt;
  
  END IF;  
  
  IF (r_cal_dlv_estm_dt  - r_cal_rcv_estm_dt) < 0 AND r_dlv_act_dt IS NOT NULL THEN
    r_cal_dlv_estm_dt := r_dlv_act_dt;
    r_cal_rcv_estm_dt := r_rcv_act_dt;
  
  END IF; 

  r_tot_tran_pln_dt := TO_CHAR(FLOOR(((r_cal_dlv_pln_dt  - r_cal_rcv_pln_dt) * 24)/24)) || 'D ' || 
                       TO_CHAR(MOD(FLOOR(((r_cal_dlv_pln_dt  - r_cal_rcv_pln_dt) * 24)),24))|| 'H' ; 
                          
  r_tot_tran_estm_dt := TO_CHAR(FLOOR(((r_cal_dlv_estm_dt  - r_cal_rcv_estm_dt) * 24)/24)) || 'D ' || 
                        TO_CHAR(MOD(FLOOR(((r_cal_dlv_estm_dt  - r_cal_rcv_estm_dt) * 24)),24))|| 'H' ; 

  r_result := r_tot_tran_pln_dt || '#' || r_tot_tran_estm_dt ;

  --DBMS_OUTPUT.PUT_LINE('ó������-'||r_result);              
    
  RETURN r_result ; 
END ;
/
