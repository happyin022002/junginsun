/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * -KOREA WHF
	  * -Wharfage Vessel Information
	  * -searchKrWhfVslInfo
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfVslInfoRSQL").append("\n"); 
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
		query.append("VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",PORT_CD" ).append("\n"); 
		query.append(",WHF_BND_CD " ).append("\n"); 
		query.append(",CALL_SGN_NO AS VSL_CALL_SGN_CD" ).append("\n"); 
		query.append(",TML_CD" ).append("\n"); 
		query.append(",ARR_TMS_NO" ).append("\n"); 
		query.append(",NVL(ARR_YR, 0) AS ARR_YR" ).append("\n"); 
		query.append(",BRTH_CD AS IO_PORT_CD" ).append("\n"); 
		query.append(",UNLD_TP_CD" ).append("\n"); 
		query.append(",SUBSTR(UNLD_AGN_ID,1,2) UNLD_AGN_CD1" ).append("\n"); 
		query.append(",SUBSTR(UNLD_AGN_ID,3,1) UNLD_AGN_CD2" ).append("\n"); 
		query.append(",SUBSTR(UNLD_AGN_ID,4,4) UNLD_AGN_CD3" ).append("\n"); 
		query.append(",WHF_VOL_DC_CD" ).append("\n"); 
		query.append(",WHF_RT" ).append("\n"); 
		query.append(",MF_REF_NO" ).append("\n"); 
		query.append("--,TO_DATE( WHF_PAY_DT, 'YYYYMMDD' ) AS WHF_PAY_DT" ).append("\n"); 
		query.append(",WHF_PAY_DT" ).append("\n"); 
		query.append(",PORT_NM" ).append("\n"); 
		query.append(",SAIL_DT" ).append("\n"); 
		query.append(",'VPS_DT' AS VPS_DT" ).append("\n"); 
		query.append(",'MRN_NO' AS MRN_NO" ).append("\n"); 
		query.append(",'MRN_CHK_NO' AS MRN_CHK_NO" ).append("\n"); 
		query.append(",PAY_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_KR_WHF_VOL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD      = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("AND SKD_VOY_NO  = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("AND SKD_DIR_CD  = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("AND WHF_BND_CD  = @[io_bnd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("AND PORT_CD     = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}