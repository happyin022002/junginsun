/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.26
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.10.26 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchScgGuidDtlFile
	  * 
	  * 2016.10.26 LIVE 실행 소스와 달라 적용
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_guid_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlFileRSQL").append("\n"); 
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
		query.append("SELECT  SPCL_CGO_GUID_ATCH_FILE_SEQ" ).append("\n"); 
		query.append("	,SPCL_CGO_GUID_CD" ).append("\n"); 
		query.append("	,SPCL_CGO_GUID_SEQ" ).append("\n"); 
		query.append("	,FILE_NM" ).append("\n"); 
		query.append("	,FILE_SAV_ID" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("FROM    SCG_GUID_DTL_FILE" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     SPCL_CGO_GUID_CD    = @[scg_flg]" ).append("\n"); 
		query.append("AND     SPCL_CGO_GUID_SEQ   = DECODE(@[spcl_cgo_guid_seq], NULL, 0, 'undefined', 0, @[spcl_cgo_guid_seq])" ).append("\n"); 
		query.append("ORDER BY SPCL_CGO_GUID_ATCH_FILE_SEQ" ).append("\n"); 

	}
}