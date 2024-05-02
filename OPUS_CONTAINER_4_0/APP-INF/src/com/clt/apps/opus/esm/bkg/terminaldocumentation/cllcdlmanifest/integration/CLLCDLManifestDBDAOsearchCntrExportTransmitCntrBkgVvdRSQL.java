/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrBkgVvdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrExportTransmitCntrBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Container Export EDI 전송시 BKG NO기분 VVD정보 구하는 쿼리.
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportTransmitCntrBkgVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrBkgVvdRSQL").append("\n");
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
		query.append("SELECT	NVL(a.vsl_cd,' ')||NVL(a.skd_voy_no,' ')||NVL(a.skd_dir_cd,' ') BVVD1," ).append("\n");
		query.append("NVL(D.CALL_SGN_NO,' ') VSL_CALLSIGN1," ).append("\n");
		query.append("NVL(D.LLOYD_NO,' ') VSL_LLOYDCODE1," ).append("\n");
		query.append("NVL(D.VSL_ENG_NM,' ') VSL_FULLNAME1," ).append("\n");
		query.append("NVL(a.pol_CD,' ') BLPOL1," ).append("\n");
		query.append("e.LOC_NM POL_FULLNAME1," ).append("\n");
		query.append("NVL(a.pod_CD,' ') BLPOD1," ).append("\n");
		query.append("f.LOC_NM POD_FULLNAME1," ).append("\n");
		query.append("NVL(TO_CHAR(b.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') POLETA1," ).append("\n");
		query.append("NVL(TO_CHAR(b.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') POLETD1," ).append("\n");
		query.append("NVL(TO_CHAR(c.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') PODETA1," ).append("\n");
		query.append("NVL(TO_CHAR(c.VPS_ETA_DT,'YYYYMMDDHH24MI'),' ') PODETD1," ).append("\n");
		query.append("'' OP_CODE" ).append("\n");
		query.append("FROM 	bkg_vvd a," ).append("\n");
		query.append("VSK_vsl_port_skd b," ).append("\n");
		query.append("VSK_vsl_port_skd c," ).append("\n");
		query.append("MDM_VSL_CNTR d," ).append("\n");
		query.append("MDM_LOCATION e," ).append("\n");
		query.append("MDM_LOCATION f" ).append("\n");
		query.append("WHERE 	a.bkg_no        	= @[form_bkg_no] and" ).append("\n");
		query.append("a.vsl_cd        	= b.vsl_cd(+) and" ).append("\n");
		query.append("a.skd_voy_no 		= b.skd_voy_no(+) and" ).append("\n");
		query.append("a.skd_dir_cd    	= b.skd_dir_cd(+) and" ).append("\n");
		query.append("a.pol_CD      		= b.VPS_PORT_CD(+) and" ).append("\n");
		query.append("b.CLPT_IND_SEQ(+)  	= '1' and" ).append("\n");
		query.append("a.vsl_cd        	= c.vsl_cd(+) and" ).append("\n");
		query.append("a.skd_voy_no 		= c.skd_voy_no(+) and" ).append("\n");
		query.append("a.skd_dir_cd    	= c.skd_dir_cd(+) and" ).append("\n");
		query.append("a.pol_CD       		= c.VPS_PORT_CD(+) and" ).append("\n");
		query.append("c.CLPT_IND_SEQ(+)  	= '1' and" ).append("\n");
		query.append("a.vsl_cd        	= d.vsl_cd(+) and" ).append("\n");
		query.append("a.pol_CD       		= e.loc_cd(+) and" ).append("\n");
		query.append("a.pod_CD       		= f.loc_cd(+)" ).append("\n");

	}
}