/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSATsVVDListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.12
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSATsVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * T/S List 화면 : ETD Date에  Relay Port를 경유하는 VVD조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSATsVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rly_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchPSATsVVDListRSQL").append("\n");
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
		query.append("SELECT SKD1.VSL_CD||SKD1.SKD_VOY_NO||SKD1.SKD_DIR_CD VVD" ).append("\n");
		query.append("FROM VSK_VSL_PORT_SKD SKD1" ).append("\n");
		query.append("WHERE SKD1.VPS_PORT_CD = @[rly_port]" ).append("\n");
		query.append("AND NVL(SKD1.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n");
		query.append("#if(${trans_tp_cd}!='E')" ).append("\n");
		query.append("AND SKD1.VPS_ETA_DT between TO_DATE(@[etd_dt],'YYYYMMDD') and TO_DATE(@[etd_dt],'YYYYMMDD') + 0.99999" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND SKD1.VPS_ETD_DT between TO_DATE(@[etd_dt],'YYYYMMDD') and TO_DATE(@[etd_dt],'YYYYMMDD') + 0.99999" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND EXISTS (SELECT  'X'" ).append("\n");
		query.append("FROM    BKG_VVD VVD1, BKG_VVD VVD2, BKG_BOOKING BKG" ).append("\n");
		query.append("WHERE   SKD1.VSL_CD = VVD2.VSL_CD" ).append("\n");
		query.append("AND     SKD1.SKD_VOY_NO = VVD2.SKD_VOY_NO" ).append("\n");
		query.append("AND     SKD1.SKD_DIR_CD = VVD2.SKD_DIR_CD" ).append("\n");
		query.append("AND     VVD1.BKG_NO = VVD2.BKG_NO" ).append("\n");
		query.append("AND     VVD1.POD_CD = @[rly_port]" ).append("\n");
		query.append("AND     VVD2.BKG_NO = BKG.BKG_NO" ).append("\n");
		query.append("AND     VVD2.POL_CD = @[rly_port]" ).append("\n");
		query.append("AND     BKG.BKG_CGO_TP_CD IN ('F','B','R')" ).append("\n");
		query.append("AND     BKG.BKG_STS_CD <> 'X' )" ).append("\n");

	}
}