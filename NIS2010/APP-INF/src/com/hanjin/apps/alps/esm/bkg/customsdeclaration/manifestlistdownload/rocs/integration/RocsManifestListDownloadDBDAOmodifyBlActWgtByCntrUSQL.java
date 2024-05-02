/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOmodifyBlActWgtByCntrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOmodifyBlActWgtByCntrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 Container 정보로부터 Actual Weight 을 조회하여 B/L 정보를 업데이트한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOmodifyBlActWgtByCntrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOmodifyBlActWgtByCntrUSQL").append("\n"); 
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
		query.append("UPDATE  BKG_CSTMS_RTM_BL" ).append("\n"); 
		query.append("SET  BKG_TTL_QTY  = nvl(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  	SUM(CNTR_MF_WGT)" ).append("\n"); 
		query.append("FROM    	BKG_CSTMS_RTM_CNTR" ).append("\n"); 
		query.append("WHERE  	VSL_CALL_REF_NO= @[frm_crn_number]" ).append("\n"); 
		query.append("AND  	BKG_NO 		= @[bkg_no]" ).append("\n"); 
		query.append("),0)" ).append("\n"); 
		query.append("WHERE  VSL_CALL_REF_NO	= @[frm_crn_number]" ).append("\n"); 
		query.append("AND  	BKG_NO 		= @[bkg_no]" ).append("\n"); 
		query.append("AND    	BL_NO 		=  SUBSTR(@[bl_no],0,12)" ).append("\n"); 

	}
}