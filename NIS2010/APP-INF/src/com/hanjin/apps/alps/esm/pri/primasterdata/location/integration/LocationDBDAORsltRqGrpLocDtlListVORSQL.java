/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationDBDAORsltRqGrpLocDtlListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.08 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.location.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAORsltRqGrpLocDtlListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pri_rq_grp_loc_dtl 조회
	  * </pre>
	  */
	public LocationDBDAORsltRqGrpLocDtlListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.location.integration ").append("\n"); 
		query.append("FileName : LocationDBDAORsltRqGrpLocDtlListVORSQL").append("\n"); 
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
		query.append("#if (${org_dest_cd} == 'B')" ).append("\n"); 
		query.append("SELECT LOC_CD" ).append("\n"); 
		query.append(", LOC_NM" ).append("\n"); 
		query.append(", RGN_CD" ).append("\n"); 
		query.append(", SCONTI_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append(", C.LOC_NM" ).append("\n"); 
		query.append(", C.RGN_CD" ).append("\n"); 
		query.append(", C.SCONTI_CD" ).append("\n"); 
		query.append("FROM PRI_RQ_GRP_LOC_DTL A" ).append("\n"); 
		query.append(", PRI_RQ_MN M" ).append("\n"); 
		query.append(", MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append(", MDM_LOCATION C" ).append("\n"); 
		query.append("WHERE A.QTTN_NO        = M.QTTN_NO" ).append("\n"); 
		query.append("AND A.QTTN_VER_NO    = M.QTTN_VER_NO" ).append("\n"); 
		query.append("AND A.LOC_CD			= C.LOC_CD" ).append("\n"); 
		query.append("AND M.SVC_SCP_CD		= B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND B.RGN_CD			= C.RGN_CD" ).append("\n"); 
		query.append("AND A.QTTN_NO        = @[qttn_no]" ).append("\n"); 
		query.append("AND A.QTTN_VER_NO    = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ    = @[grp_loc_seq]" ).append("\n"); 
		query.append("AND B.DELT_FLG		= 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY LOC_CD, LOC_NM, RGN_CD, SCONTI_CD HAVING COUNT(*)>1" ).append("\n"); 
		query.append("ORDER BY LOC_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${org_dest_cd} == 'O' || ${org_dest_cd} == 'D')" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append(", C.LOC_NM" ).append("\n"); 
		query.append(", C.RGN_CD" ).append("\n"); 
		query.append(", C.SCONTI_CD" ).append("\n"); 
		query.append("FROM PRI_RQ_GRP_LOC_DTL A" ).append("\n"); 
		query.append(", PRI_RQ_MN M" ).append("\n"); 
		query.append(", MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append(", MDM_LOCATION C" ).append("\n"); 
		query.append("WHERE A.QTTN_NO        = M.QTTN_NO" ).append("\n"); 
		query.append("AND A.QTTN_VER_NO    = M.QTTN_VER_NO" ).append("\n"); 
		query.append("AND A.LOC_CD			= C.LOC_CD" ).append("\n"); 
		query.append("AND M.SVC_SCP_CD		= B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND B.RGN_CD			= C.RGN_CD" ).append("\n"); 
		query.append("AND A.QTTN_NO        = @[qttn_no]" ).append("\n"); 
		query.append("AND A.QTTN_VER_NO    = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ    = @[grp_loc_seq]" ).append("\n"); 
		query.append("AND B.ORG_DEST_CD	= @[org_dest_cd]" ).append("\n"); 
		query.append("AND B.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("ORDER BY A.LOC_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append(", B.LOC_NM" ).append("\n"); 
		query.append(", B.RGN_CD" ).append("\n"); 
		query.append(", B.SCONTI_CD" ).append("\n"); 
		query.append("FROM PRI_RQ_GRP_LOC_DTL A" ).append("\n"); 
		query.append(", MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.QTTN_NO        = @[qttn_no]" ).append("\n"); 
		query.append("AND A.QTTN_VER_NO    = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND A.GRP_LOC_SEQ    = @[grp_loc_seq]" ).append("\n"); 
		query.append("ORDER BY A.LOC_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}