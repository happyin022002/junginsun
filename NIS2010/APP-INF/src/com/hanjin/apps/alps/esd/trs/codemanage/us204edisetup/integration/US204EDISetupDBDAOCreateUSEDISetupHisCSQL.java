/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : US204EDISetupDBDAOCreateUSEDISetupHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class US204EDISetupDBDAOCreateUSEDISetupHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US EDI Setup History 저장
	  * </pre>
	  */
	public US204EDISetupDBDAOCreateUSEDISetupHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration").append("\n"); 
		query.append("FileName : US204EDISetupDBDAOCreateUSEDISetupHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_EDI_USA_RCVR_DTL_HIS (VNDR_SEQ, HIS_SEQ, EDI_RCVR_NM, EDI_RCVR_NM_USE_FLG, CRE_OFC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT C.VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT NVL(HIS_SEQ+1, 1) " ).append("\n"); 
		query.append("         FROM (SELECT B.HIS_SEQ FROM TRS_EDI_USA_RCVR_DTL A, TRS_EDI_USA_RCVR_DTL_HIS B" ).append("\n"); 
		query.append("                WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                  AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("                ORDER BY B.HIS_SEQ DESC)" ).append("\n"); 
		query.append("        WHERE ROWNUM=1) HIS_SEQ" ).append("\n"); 
		query.append("      ,C.EDI_RCVR_NM" ).append("\n"); 
		query.append("      ,C.EDI_RCVR_NM_USE_FLG" ).append("\n"); 
		query.append("      ,C.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,C.CRE_USR_ID" ).append("\n"); 
		query.append("      ,C.CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append(" FROM TRS_EDI_USA_RCVR_DTL C" ).append("\n"); 
		query.append("WHERE C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}