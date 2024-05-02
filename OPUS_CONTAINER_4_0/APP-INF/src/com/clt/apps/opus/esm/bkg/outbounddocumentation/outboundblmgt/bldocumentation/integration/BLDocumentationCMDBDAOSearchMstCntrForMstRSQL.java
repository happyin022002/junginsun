/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchMstCntrForMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.11.24 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchMstCntrForMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MstContainer 정보 수정을 위한 조회
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchMstCntrForMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchMstCntrForMstRSQL").append("\n"); 
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
		query.append("select SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(", CNMV_YR" ).append("\n"); 
		query.append(", CNMV_ID_NO" ).append("\n"); 
		query.append(", CNMV_SEQ" ).append("\n"); 
		query.append(", CNMV_SPLIT_NO" ).append("\n"); 
		query.append(", CNMV_CYC_NO" ).append("\n"); 
		query.append(", to_char(CNMV_DT, 'YYYYMMDD HH24:MI') CNMV_DT" ).append("\n"); 
		query.append(", BKG_KNT" ).append("\n"); 
		query.append(", CRNT_YD_CD" ).append("\n"); 
		query.append(", DEST_YD_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", CNMV_STS_CD" ).append("\n"); 
		query.append(", ACIAC_DIV_CD" ).append("\n"); 
		query.append("from mst_container" ).append("\n"); 
		query.append("where cntr_no = @[cntr_no]" ).append("\n"); 

	}
}