/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDDAOsearchIsf5RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.24 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDDAOsearchIsf5RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim ISF5 유형(IT_IPI_LOCAL IN ('F','V') OR IT_ITTYPE IN ('62','63'))인지 확인.
	  * 2012.04.10 윤태승 [CHM-201216919-01] [BKG] US AMS ISF-5 전송 로직 보완
	  * 2014.01.07 [CHM-201328073] [US ACE] ISF-5 전송로직 변경 요청
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDDAOsearchIsf5RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDDAOsearchIsf5RSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append(" WHERE BL.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND BL.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("   AND BL.CNT_CD = IBD.CNT_CD" ).append("\n"); 
		query.append("   AND BL.BL_NO = IBD.BL_NO" ).append("\n"); 
		query.append("   AND BL.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("   AND (IBD.CSTMS_CLR_TP_CD IN ('F','V')" ).append("\n"); 
		query.append("         OR" ).append("\n"); 
		query.append("        IBD.IBD_TRSP_TP_CD IN ('62','63')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND (BL.CSTMS_FILE_TP_CD = '3'   --FILER '3' : MBL (HOUSE BL이 없는거)" ).append("\n"); 
		query.append("        OR" ).append("\n"); 
		query.append("        (BL.MF_NO IS NOT NULL AND BL.CSTMS_FILE_TP_CD = '1') --FILER '1' : 선사가 대신 신고하는 HOUSE BL" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("--   AND DECODE(BL.MF_NO, NULL, NVL(BL.CSTMS_FILE_TP_CD, BKG.USA_CSTMS_FILE_CD), 'HBL') NOT IN ('1')" ).append("\n"); 
		query.append("--   AND BL.CSTMS_FILE_TP_CD != '2'" ).append("\n"); 

	}
}