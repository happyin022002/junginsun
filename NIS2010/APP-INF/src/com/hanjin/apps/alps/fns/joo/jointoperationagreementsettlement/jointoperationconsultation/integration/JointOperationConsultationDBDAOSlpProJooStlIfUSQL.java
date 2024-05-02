/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlpProJooStlIfUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.08.22 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlpProJooStlIfUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_SETTLEMENT를 인터페이스 에러난 건 Update한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlpProJooStlIfUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("issuer_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlpProJooStlIfUSQL").append("\n"); 
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
		query.append("UPDATE JOO_SETTLEMENT S SET" ).append("\n"); 
		query.append("             S.AP_CXL_FLG = 'N'" ).append("\n"); 
		query.append("            ,S.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("            ,S.UPD_USR_ID  = @[issuer_id]" ).append("\n"); 
		query.append("        WHERE 1 = 1 " ).append("\n"); 
		query.append("        AND   S.ACCT_YRMON||S.STL_VVD_SEQ||S.STL_SEQ IN " ).append("\n"); 
		query.append("                ( SELECT  D.ACCT_YRMON||D.STL_VVD_SEQ||D.STL_SEQ" ).append("\n"); 
		query.append("                  FROM  JOO_STL_CMB C, JOO_STL_CMB_DTL D" ).append("\n"); 
		query.append("                  WHERE C.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("                  AND   C.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("                  AND   C.STL_CMB_SEQ = TO_NUMBER(@[stl_cmb_seq])" ).append("\n"); 
		query.append("                  AND   C.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("                  AND   C.ACCT_YRMON = D.ACCT_YRMON" ).append("\n"); 
		query.append("                  AND   C.JO_CRR_CD = D.JO_CRR_CD" ).append("\n"); 
		query.append("                  AND   C.STL_CMB_SEQ = D.STL_CMB_SEQ" ).append("\n"); 
		query.append("                  AND   C.RE_DIVR_CD = D.RE_DIVR_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("		 AND NVL(S.AP_CXL_FLG, 'N') = 'Y'" ).append("\n"); 

	}
}