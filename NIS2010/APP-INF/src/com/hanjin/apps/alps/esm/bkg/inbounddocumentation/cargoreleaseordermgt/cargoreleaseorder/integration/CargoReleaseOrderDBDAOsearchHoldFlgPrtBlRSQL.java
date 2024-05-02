/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchHoldFlgPrtBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.11.06 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchHoldFlgPrtBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchHoldFlgPrtBlRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchHoldFlgPrtBlRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT I.BL_NO AS BL_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL   B," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_CNTR H," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_BL   I," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_CNTR J," ).append("\n"); 
		query.append("BKG_BOOKING        K," ).append("\n"); 
		query.append("BKG_CSTMS_ADV_IBD  L" ).append("\n"); 
		query.append("WHERE B.CNT_CD      = 'US'" ).append("\n"); 
		query.append("AND B.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND B.CNT_CD     = H.CNT_CD" ).append("\n"); 
		query.append("AND B.BL_NO      = H.BL_NO" ).append("\n"); 
		query.append("AND B.VSL_CD     = I.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = I.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = I.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.CSTMS_POL_CD = I.CSTMS_POL_CD" ).append("\n"); 
		query.append("AND I.CNT_CD       = 'US'" ).append("\n"); 
		query.append("AND I.CNT_CD       = J.CNT_CD" ).append("\n"); 
		query.append("AND I.BL_NO        = J.BL_NO" ).append("\n"); 
		query.append("AND B.BL_NO        <> I.BL_NO" ).append("\n"); 
		query.append("AND H.CNTR_NO      = J.CNTR_NO" ).append("\n"); 
		query.append("AND I.BKG_NO       = K.BKG_NO" ).append("\n"); 
		query.append("AND K.BKG_STS_CD   <> 'X'" ).append("\n"); 
		query.append("AND I.CNT_CD       = L.CNT_CD" ).append("\n"); 
		query.append("AND I.BL_NO        = L.BL_NO" ).append("\n"); 
		query.append("AND I.MF_NO IS NULL" ).append("\n"); 

	}
}