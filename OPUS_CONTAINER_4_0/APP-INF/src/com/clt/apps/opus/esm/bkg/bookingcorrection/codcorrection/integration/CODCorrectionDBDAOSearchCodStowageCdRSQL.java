/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOSearchCodStowageCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOSearchCodStowageCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 cntr의 stowage를 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOSearchCodStowageCdRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhnd_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhnd_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOSearchCodStowageCdRSQL").append("\n"); 
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
		query.append("SELECT cntr.cntr_no, BP.BAY||BP.ROWW||BP.TIER cntr_stwg_no" ).append("\n"); 
		query.append("FROM BAY_PLAN BP, bkg_container cntr, VSK_VSL_PORT_SKD skd" ).append("\n"); 
		query.append("WHERE cntr.bkg_no  = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO = BP.ID" ).append("\n"); 
		query.append("and BP.VSL_CD    = substr(@[rhnd_vvd], 1, 4)" ).append("\n"); 
		query.append("AND BP.VOY_NO    = substr(@[rhnd_vvd], 5, 4)" ).append("\n"); 
		query.append("AND BP.DIR_CD    = substr(@[rhnd_vvd], 9, 1)" ).append("\n"); 
		query.append("AND Bp.VSL_CD    = skd.VSL_CD" ).append("\n"); 
		query.append("AND Bp.VOY_NO    = skd.SKD_VOY_NO" ).append("\n"); 
		query.append("AND Bp.DIR_CD    = skd.SKD_DIR_CD" ).append("\n"); 
		query.append("AND Bp.PORT_CD   = skd.VPS_PORT_CD" ).append("\n"); 
		query.append("AND Bp.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("AND skd.CLPT_SEQ <= (SELECT min(skd.CLPT_SEQ)" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD skd" ).append("\n"); 
		query.append("WHERE skd.VSL_CD       = substr(@[rhnd_vvd], 1, 4)" ).append("\n"); 
		query.append("AND skd.SKD_VOY_NO   = substr(@[rhnd_vvd], 5, 4)" ).append("\n"); 
		query.append("AND skd.SKD_DIR_CD   = substr(@[rhnd_vvd], 9, 1)" ).append("\n"); 
		query.append("AND skd.yd_cd        = @[rhnd_yd_cd])" ).append("\n"); 

	}
}