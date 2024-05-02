/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchVesselArrivalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaCustomsTransmissionDBDAOsearchVesselArrivalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카 세관 신고용 Manifest Vessel Arrival 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchVesselArrivalRSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchVesselArrivalRSQL").append("\n"); 
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
		query.append("SELECT VSL_RGST_NO||'.'||SKD_VOY_NO||SKD_DIR_CD||'.'||REPLACE(VSL_NM,' ','')||'.'||TO_CHAR(ETD_DT,'DDMMYYYY')||'.'||'VR' file_name ," ).append("\n"); 
		query.append("           VSL_NM vsl_fullname," ).append("\n"); 
		query.append("           SKD_VOY_NO||SKD_DIR_CD voyage_code," ).append("\n"); 
		query.append("           TO_CHAR(ETA_DT,'MM/DD/YYYY') arvl_dt," ).append("\n"); 
		query.append("           TO_CHAR(ETA_DT,'HH24MISS') arvl_tm," ).append("\n"); 
		query.append("           TO_CHAR(ETD_DT,'MM/DD/YYYY') dept_dt," ).append("\n"); 
		query.append("           TO_CHAR(ETD_DT,'HH24MISS') dept_tm," ).append("\n"); 
		query.append("           CAP_NM capt_nm," ).append("\n"); 
		query.append("           VSL_CNT_CD vslflg," ).append("\n"); 
		query.append("           SVC_PRE_PORT_CD dept_port," ).append("\n"); 
		query.append("           PORT_CD arvl_port," ).append("\n"); 
		query.append("           SHP_AGN_NM shp_agt," ).append("\n"); 
		query.append("           LOCL_SHP_AGN_NM shp_agt2" ).append("\n"); 
		query.append("    FROM    BKG_CSTMS_SRI_VVD	" ).append("\n"); 
		query.append("	WHERE   VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("    AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("    AND     PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("	AND		VSL_RGST_NO  =  @[vsl_rgst_no]" ).append("\n"); 

	}
}