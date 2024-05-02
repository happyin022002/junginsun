/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCOPInfoPolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.26 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCOPInfoPolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPInfoPol
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCOPInfoPolRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCOPInfoPolRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("LO.LOC_NM POL_NAME," ).append("\n"); 
		query.append("BVD.POL_CD POL_CODE," ).append("\n"); 
		query.append("DECODE(LO.CNT_CD, 'US', 'D', 'K') POL_AMSQUAL," ).append("\n"); 
		query.append("LO.LOC_AMS_PORT_CD POL_AMSPORT" ).append("\n"); 
		query.append("FROM MDM_LOCATION LO," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("BKG_VVD BVD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BVD.BKG_NO = @[e_bkg_no]" ).append("\n"); 
		query.append("AND BVD.POL_CD = @[e_pol_loc]" ).append("\n"); 
		query.append("AND VPS.VSL_CD(+) = BVD.VSL_CD" ).append("\n"); 
		query.append("AND VPS.SKD_VOY_NO(+) = BVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VPS.SKD_DIR_CD(+) = BVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD(+) = @[e_pol_loc]" ).append("\n"); 
		query.append("AND NVL(VPS.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND LO.LOC_CD(+) = @[e_pol_loc] -- VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}