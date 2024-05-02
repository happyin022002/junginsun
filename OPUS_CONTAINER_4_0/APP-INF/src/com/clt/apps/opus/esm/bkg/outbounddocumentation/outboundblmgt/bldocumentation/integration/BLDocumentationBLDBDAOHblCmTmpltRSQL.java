/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOHblCmTmpltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.08.14 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOHblCmTmpltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationBLDBDAOHblCmTmpltRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ulti_cnee_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOHblCmTmpltRSQL").append("\n"); 
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
		query.append("SELECT B.OFC_CD" ).append("\n"); 
		query.append(",      B.PROF_SEQ" ).append("\n"); 
		query.append(",      B.PROF_SUB_SEQ" ).append("\n"); 
		query.append(",      B.CSTMS_DESC" ).append("\n"); 
		query.append(",      B.HAMO_TRF_CD" ).append("\n"); 
		query.append(",      B.DELT_FLG" ).append("\n"); 
		query.append(",      B.CRE_USR_ID" ).append("\n"); 
		query.append(",      B.CRE_DT" ).append("\n"); 
		query.append(",      B.UPD_USR_ID" ).append("\n"); 
		query.append(",      B.UPD_DT" ).append("\n"); 
		query.append("FROM   BKG_NVOCC_PROF A, BKG_NVOCC_PROF_CNTR_MF B" ).append("\n"); 
		query.append("WHERE  A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND    A.PROF_SEQ = B.PROF_SEQ" ).append("\n"); 
		query.append("AND    B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    UPPER(A.ACT_SHPR_NM) like '%' || UPPER(@[act_shpr_nm]) || '%'" ).append("\n"); 
		query.append("AND    UPPER(A.ULTI_CNEE_NM) like '%' || UPPER(@[ulti_cnee_nm]) || '%'" ).append("\n"); 

	}
}