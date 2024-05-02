/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationDBDAORsltScgGrpLocDtlListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAORsltScgGrpLocDtlListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * surcharge location code 조회
	  * </pre>
	  */
	public LocationDBDAORsltScgGrpLocDtlListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltScgGrpLocDtlListVORSQL").append("\n"); 
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
		query.append("SELECT CASE A.DTL_LOC_TP_CD WHEN 'L' THEN L.LOC_CD" ).append("\n"); 
		query.append("WHEN 'C' THEN c.cnt_cd" ).append("\n"); 
		query.append("WHEN 'R' THEN r.rgn_cd" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END LOC_CD" ).append("\n"); 
		query.append(", CASE A.DTL_LOC_TP_CD WHEN 'L' THEN L.LOC_NM" ).append("\n"); 
		query.append("WHEN 'C' THEN c.cnt_NM" ).append("\n"); 
		query.append("WHEN 'R' THEN r.rgn_NM" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END LOC_NM" ).append("\n"); 
		query.append(", CASE A.DTL_LOC_TP_CD WHEN 'L' THEN L.RGN_CD" ).append("\n"); 
		query.append("WHEN 'R' THEN r.RGN_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END RGN_CD" ).append("\n"); 
		query.append(", CASE A.DTL_LOC_TP_CD WHEN 'L' THEN L.SCONTI_CD" ).append("\n"); 
		query.append("WHEN 'C' THEN C.SCONTI_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END SCONTI_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append(", MDM_LOCATION L" ).append("\n"); 
		query.append(", MDM_COUNTRY C" ).append("\n"); 
		query.append(", MDM_REGION R" ).append("\n"); 
		query.append("WHERE A.DTL_LOC_DEF_CD = L.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.DTL_LOC_DEF_CD = C.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.DTL_LOC_DEF_CD = R.RGN_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ 	= @[grp_loc_seq]" ).append("\n"); 
		query.append("AND A.CHG_CD 		= @[chg_cd]" ).append("\n"); 
		query.append("ORDER BY A.DTL_LOC_TP_CD ASC" ).append("\n"); 

	}
}