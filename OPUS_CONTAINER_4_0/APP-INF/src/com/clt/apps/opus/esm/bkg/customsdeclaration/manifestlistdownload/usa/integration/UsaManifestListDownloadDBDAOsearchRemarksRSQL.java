/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchRemarksRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchRemarksRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaBlRemarkVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchRemarksRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchRemarksRSQL").append("\n"); 
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
		query.append("SELECT  B.DIFF_RMK" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.RAIL_CRR_REF_NO" ).append("\n"); 
		query.append(",C.USA_IB_TRSP_NO AS IBD_TRSP_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("--,BKG_CSTMS_ADV_IBD I" ).append("\n"); 
		query.append(",(   SELECT  C.BL_NO" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.USA_IB_TRSP_NO" ).append("\n"); 
		query.append(",C.RAIL_CRR_REF_NO" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     C.CNT_CD = 'CA'" ).append("\n"); 
		query.append("AND     C.BL_NO = @[bl_no]" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND		B.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND     B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("--AND     B.BL_NO = I.BL_NO(+)" ).append("\n"); 
		query.append("AND     B.BL_NO = C.BL_NO(+)" ).append("\n"); 
		query.append("AND     B.CSTMS_POD_CD LIKE 'CA%'" ).append("\n"); 

	}
}