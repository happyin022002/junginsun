/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchDoRefInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchDoRefInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O Release를 위한 기본 Reference정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDoRefInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchDoRefInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",	CSTMS_REF_NM" ).append("\n"); 
		query.append(",	CSTMS_REF_CTNT" ).append("\n"); 
		query.append(",	CSTMS_ASGN_NM" ).append("\n"); 
		query.append(",	CSTMS_ASGN_CTNT" ).append("\n"); 
		query.append(",	INTER_RMK" ).append("\n"); 
		query.append(",	DO_HLD_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	INFO_CGO_FLG" ).append("\n"); 
		query.append(",	IDA_IMP_GEN_MF_NO" ).append("\n"); 
		query.append(",	IDA_CGOR_ORD_YR" ).append("\n"); 
		query.append(",	IDA_CSTMS_ASGN_LINE_NO" ).append("\n"); 
		query.append(",	DO_SPLIT_FLG" ).append("\n"); 
		query.append(",	CY_OP_CD" ).append("\n"); 
		query.append("FROM BKG_DO_REF" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}