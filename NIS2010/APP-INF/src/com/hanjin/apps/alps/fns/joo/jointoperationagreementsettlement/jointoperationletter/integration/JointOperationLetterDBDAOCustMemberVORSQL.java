/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationLetterDBDAOCustMemberVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.12.02 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOCustMemberVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.11.08 이준범 [CHM-201006731-01]
	  *  1. 대상 기능
	  *    - JO Member Information Creation(JOO_0066)
	  *    - Inquiry of JO Member Information(JOO_0067)
	  *  2. 보완 대상
	  *    - Revenue Lane 정보 반영 
	  *    - MS Office( Excel, Worl, Power Point등) 첨부
	  *    - Carrier Name등 컬럼 반영
	  * 2010.12.02 이준범 [CHM-201007349-01]
	  * 1. 보완 기능 
	  *    - JO Member Information Creation
	  *    - Inquiry of JO Member Information
	  *  2. 보완 요청 사항
	  *    - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
	  * </pre>
	  */
	public JointOperationLetterDBDAOCustMemberVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOCustMemberVORSQL").append("\n"); 
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
		query.append("SELECT A.JO_CRR_CD" ).append("\n"); 
		query.append("      ,A.RLANE_CD " ).append("\n"); 
		query.append("      ,A.CRR_CNTC_SEQ" ).append("\n"); 
		query.append("      ,ROW_NUMBER() OVER (PARTITION BY A.JO_CRR_CD, A.RLANE_CD ORDER BY A.JO_CRR_CD, A.RLANE_CD, A.CRR_CNTC_SEQ ) RID" ).append("\n"); 
		query.append("      ,( SELECT COUNT(C.FILE_SAV_ID) FROM JOO_CNTC_MBR_ATCH_FILE C WHERE C.JO_CRR_CD = A.JO_CRR_CD AND C.CRR_CNTC_SEQ = A.CRR_CNTC_SEQ ) AS FILE_CNT" ).append("\n"); 
		query.append("      ,B.CRR_NM" ).append("\n"); 
		query.append("      ,A.CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,A.JO_CNTC_EML" ).append("\n"); 
		query.append("      ,A.JO_CNTC_PHN_NO" ).append("\n"); 
		query.append("      ,A.JO_CNTC_FAX_NO" ).append("\n"); 
		query.append("      ,A.SVC_IN_CHG_NM" ).append("\n"); 
		query.append("      ,A.JO_CNTC_OFC_ADDR" ).append("\n"); 
		query.append("      ,'' AS USR_ID" ).append("\n"); 
		query.append("      ,A.JO_CNTC_PIC_ID" ).append("\n"); 
		query.append("      ,C.USR_NM" ).append("\n"); 
		query.append("      ,D.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("      ,C.OFC_CD" ).append("\n"); 
		query.append("      ,A.JO_CNTC_ST_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CRE_DT, 'YYYYMMDD') AS CRE_DT      " ).append("\n"); 
		query.append("  FROM JOO_CNTC_MBR A" ).append("\n"); 
		query.append("      ,MDM_CARRIER B" ).append("\n"); 
		query.append("      ,COM_USER C" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION D" ).append("\n"); 
		query.append(" WHERE A.JO_CRR_CD = B.CRR_CD " ).append("\n"); 
		query.append("   AND A.JO_CNTC_PIC_ID = C.USR_ID(+)" ).append("\n"); 
		query.append("   AND C.OFC_CD = D.OFC_CD(+)" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != 'ALL' && ${jo_crr_cd} != '') " ).append("\n"); 
		query.append("   AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != 'ALL' && ${rlane_cd} != '') " ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.JO_CRR_CD" ).append("\n"); 
		query.append("        ,A.RLANE_CD" ).append("\n"); 
		query.append("        ,A.CRR_CNTC_SEQ" ).append("\n"); 

	}
}