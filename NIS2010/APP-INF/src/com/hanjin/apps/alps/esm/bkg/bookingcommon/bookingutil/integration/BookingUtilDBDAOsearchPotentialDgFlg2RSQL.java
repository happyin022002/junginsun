/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOsearchPotentialDgFlg2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchPotentialDgFlg2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * potential DG화물목록을 체크한다.
	  * 어디서 걸린 것인지 체크하기 위해 걸린 키워드 앞에 해당하는 컬럼붙여서 구분
	  * </pre>
	  */
	public BookingUtilDBDAOsearchPotentialDgFlg2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchPotentialDgFlg2RSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT DECODE ((SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_DG_CGO " ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND ROWNUM = 1),'Y','N','','Y') flg" ).append("\n"); 
		query.append("       ,NVL(BKG_JOIN_FNC(CURSOR((SELECT BLCK_KW_NM " ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    #if (${div_cd}== 'MND' || ${div_cd}== 'All')" ).append("\n"); 
		query.append("                        SELECT CASE WHEN BHCC.BLCK_KW_NM is not null then 'MND_CSTMS_'||BHCC.BLCK_KW_NM END BLCK_KW_NM " ).append("\n"); 
		query.append("                        FROM BKG_BLCK_KW_LIST BHCC" ).append("\n"); 
		query.append("                        #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                             ,BKG_BL_DOC_HIS BBD" ).append("\n"); 
		query.append("                        WHERE BBD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND BBD.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                              ,BKG_BL_DOC BBD" ).append("\n"); 
		query.append("                        WHERE BBD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        #end     " ).append("\n"); 
		query.append("                        AND BHCC.BLCK_KW_TP_CD = 'MIS'" ).append("\n"); 
		query.append("                        AND UPPER(BBD.CSTMS_DESC) LIKE '%'||BHCC.BLCK_KW_NM||'%'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT CASE WHEN BHCC.BLCK_KW_NM is not null THEN 'MND_CMDT_'||BHCC.BLCK_KW_NM END BLCK_KW_NM" ).append("\n"); 
		query.append("                        FROM BKG_BLCK_KW_LIST BHCC" ).append("\n"); 
		query.append("                        #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                             ,BKG_BL_MK_DESC_HIS BBM" ).append("\n"); 
		query.append("                        WHERE BBM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND BBM.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                              ,BKG_BL_MK_DESC BBM" ).append("\n"); 
		query.append("                        WHERE BBM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        #end   " ).append("\n"); 
		query.append("                        AND BLCK_KW_TP_CD = 'MIS'" ).append("\n"); 
		query.append("                        AND BBM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND UPPER(BBM.CMDT_DESC) LIKE '%'||BHCC.BLCK_KW_NM||'%'" ).append("\n"); 
		query.append("                    #end  " ).append("\n"); 
		query.append("                    #if (${div_cd}== 'All')" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                    #end  " ).append("\n"); 
		query.append("                    #if (${div_cd}== 'CM' || ${div_cd}== 'All')" ).append("\n"); 
		query.append("                        SELECT BHCC.BLCK_KW_NM" ).append("\n"); 
		query.append("                        FROM BKG_BLCK_KW_LIST BHCC" ).append("\n"); 
		query.append("                        #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                            ,BKG_CNTR_MF_DESC_HIS BBMD" ).append("\n"); 
		query.append("                        WHERE BBMD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND BBMD.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                             ,BKG_CNTR_MF_DESC BBMD" ).append("\n"); 
		query.append("                        WHERE BBMD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        #end   " ).append("\n"); 
		query.append("                        AND BHCC.BLCK_KW_TP_CD = 'MIS'" ).append("\n"); 
		query.append("                        AND UPPER(BBMD.CNTR_MF_GDS_DESC) LIKE '%'||BHCC.BLCK_KW_NM||'%'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                    #if (${div_cd}== 'All')" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                    #end  " ).append("\n"); 
		query.append("                    #if (${div_cd}== 'RMK' || ${div_cd}== 'All')" ).append("\n"); 
		query.append("                        SELECT BHCC.BLCK_KW_NM" ).append("\n"); 
		query.append("                        FROM BKG_BLCK_KW_LIST BHCC" ).append("\n"); 
		query.append("                        #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                            ,BKG_BKG_HIS BB" ).append("\n"); 
		query.append("                        WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND BB.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            ,BKG_BOOKING BB" ).append("\n"); 
		query.append("                        WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        #end  " ).append("\n"); 
		query.append("                        AND BLCK_KW_TP_CD = 'MIS'" ).append("\n"); 
		query.append("                        AND (UPPER(BB.XTER_RMK) LIKE '%'||BHCC.BLCK_KW_NM||'%'" ).append("\n"); 
		query.append("                        OR UPPER(BB.INTER_RMK) LIKE '%'||BHCC.BLCK_KW_NM||'%')" ).append("\n"); 
		query.append("                    #end  " ).append("\n"); 
		query.append("                        )))),'') RSLT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}