CREATE OR REPLACE FUNCTION NISADM.SPC_RGN_OFC_CONV_FNC2 ( v_aq_ofc_cd IN VARCHAR2, v_rgn_ofc_cd IN VARCHAR2)
                                                                                                          
RETURN VARCHAR2                                                                                           
authid current_user                                                                                       
                                                                                                          
IS                                                                                                          
/******************************************************************************                           
   Name         :   SPC_RGN_OFC_CONV_FNC2                                                                    
   Purpose      :   해당 Office별 Area Code를 찾는 Function                     
   Table        :   none                                                                             
   System       :   ALPS > Sales Management > Space Control                                                                   
   History      :   Ver 1.0 김수정 2012.06.11
******************************************************************************/                    
                                                                                                          
    v_rtn_ofc_cd VARCHAR2(7);  
    v_cnt_cd     VARCHAR2(2);                                                                           
                                                                                                          
BEGIN                       

    SELECT L.CNT_CD
      INTO v_cnt_cd
      FROM MDM_ORGANIZATION O, MDM_LOCATION L
     WHERE OFC_CD = v_rgn_ofc_cd
       AND O.LOC_CD = L.LOC_CD
    ;
                                                                                  
    -- Area Code Mapping                                                                              
    IF v_rgn_ofc_cd IN ('HKGSC', 'SZPSC', 'XMNSC') THEN
        v_rtn_ofc_cd := 'SZPDC';
    ELSIF v_rgn_ofc_cd IN ('SELSA', 'TYOSC', 'TPESC') THEN
        v_rtn_ofc_cd := 'SHAAR';
    ELSIF v_cnt_cd = 'CN' THEN
        v_rtn_ofc_cd := 'SHADNC';
    ELSE
        v_rtn_ofc_cd := v_aq_ofc_cd;
    END IF;
                                                                                                  
                                                                                                          
    RETURN v_rtn_ofc_cd;                                                                                  
END ;
