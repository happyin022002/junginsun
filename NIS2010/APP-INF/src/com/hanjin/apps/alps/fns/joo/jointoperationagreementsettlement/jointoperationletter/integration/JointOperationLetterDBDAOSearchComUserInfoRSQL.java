/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationLetterDBDAOSearchComUserInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.30 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOSearchComUserInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOSearchComUserInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOSearchComUserInfoRSQL").append("\n"); 
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
		query.append("SELECT    USR_NM,USR_EML,JB_ENG_NM, NVL(LST_LGIN_OFC_CD,OFC_CD) OFC_CD,XTN_PHN_NO,FAX_NO," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT    S.n4th_stmt_ctnt" ).append("\n"); 
		query.append("FROM    JOO_LTR_TMPLT S" ).append("\n"); 
		query.append("WHERE    S.JO_LTR_TMPLT_SEQ = (" ).append("\n"); 
		query.append("/**/                             SELECT    /*+ index_desc( A  XPKJOO_LTR_TMPLT) */" ).append("\n"); 
		query.append("/**/                                       A.JO_LTR_TMPLT_SEQ" ).append("\n"); 
		query.append("/**/                               FROM    JOO_LTR_TMPLT A" ).append("\n"); 
		query.append("/**/                              WHERE    A.OFC_CD =  @[ofc_cd]" ).append("\n"); 
		query.append("/**/                                AND    A.JO_LTR_TP_CD = @[jo_ltr_tp_cd]" ).append("\n"); 
		query.append("/**/                                AND    ROWNUM=1))GREETING" ).append("\n"); 
		query.append("FROM      COM_USER" ).append("\n"); 
		query.append("WHERE     USR_ID = @[usr_id]" ).append("\n"); 

	}
}