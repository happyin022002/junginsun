/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.07 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target Port에 일정기간내 접안 예정 스케줄의 VVD를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSAVVDRSQL").append("\n"); 
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
		query.append("SELECT VPS.VSL_CD VSL_CD" ).append("\n"); 
		query.append(", VPS.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append(", VPS.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append(", PSA.PVN PSA_VSL_NM" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append(", (SELECT VSL_CD, MAX(PSA_VSL_NM) PVN" ).append("\n"); 
		query.append("FROM BKG_CSTMS_PSA_VVD" ).append("\n"); 
		query.append("GROUP BY VSL_CD) PSA" ).append("\n"); 
		query.append("WHERE VPS.VPS_PORT_CD = @[port_cd]   /* PORT */" ).append("\n"); 
		query.append("AND VPS.VPS_ETB_DT BETWEEN TO_DATE(@[etb_dt1], 'YYYY-MM-DD') AND TO_DATE(@[etb_dt2], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND NVL(TURN_PORT_IND_CD, ' ') NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("AND VPS.VSL_CD = PSA.VSL_CD(+)" ).append("\n"); 
		query.append("GROUP BY VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD, PSA.PVN" ).append("\n"); 

	}
}