/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LocationDBDAORsltSpScpGrpLocDtlListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAORsltSpScpGrpLocDtlListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltSpScpGrpLocDtlListVO
	  * </pre>
	  */
	public LocationDBDAORsltSpScpGrpLocDtlListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_grp_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAORsltSpScpGrpLocDtlListVORSQL").append("\n"); 
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
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append("	 , B.LOC_NM" ).append("\n"); 
		query.append("	 , B.SCONTI_CD" ).append("\n"); 
		query.append("	 , B.RGN_CD" ).append("\n"); 
		query.append("     , B.STE_CD" ).append("\n"); 
		query.append("     , B.CNT_CD" ).append("\n"); 
		query.append("     , B.UN_LOC_CD" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_GRP_LOC_DTL A" ).append("\n"); 
		query.append("     , MDM_LOCATION B" ).append("\n"); 
		query.append(" WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.GRP_LOC_SEQ = @[combo_grp_loc_cd]" ).append("\n"); 
		query.append(" ORDER BY A.LOC_CD ASC" ).append("\n"); 

	}
}