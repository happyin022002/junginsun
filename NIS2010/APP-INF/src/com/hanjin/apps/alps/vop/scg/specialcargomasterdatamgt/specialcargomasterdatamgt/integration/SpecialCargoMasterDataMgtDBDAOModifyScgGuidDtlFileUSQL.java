/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOModifyScgGuidDtlFileUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.16
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.16 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOModifyScgGuidDtlFileUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyScgGuidDtlFile
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOModifyScgGuidDtlFileUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_guid_atch_file_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_guid_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration ").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOModifyScgGuidDtlFileUSQL").append("\n"); 
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
		query.append("UPDATE SCG_GUID_DTL_FILE" ).append("\n"); 
		query.append("		 FILE_NM      = @[file_nm]" ).append("\n"); 
		query.append("        ,FILE_SAV_ID      = @[file_sav_id]" ).append("\n"); 
		query.append("    	,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("    	,UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHERE	SPCL_CGO_GUID_CD = @[spcl_cgo_guid_cd]" ).append("\n"); 
		query.append("AND	SPCL_CGO_GUID_SEQ = @[spcl_cgo_guid_seq]" ).append("\n"); 
		query.append("AND SPCL_CGO_GUID_ATCH_FILE_SEQ = @[spcl_cgo_guid_atch_file_seq]" ).append("\n"); 

	}
}