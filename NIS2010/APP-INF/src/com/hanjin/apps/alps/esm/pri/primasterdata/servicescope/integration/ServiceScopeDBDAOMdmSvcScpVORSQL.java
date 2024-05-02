/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceScopeDBDAOMdmSvcScpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.14 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceScopeDBDAOMdmSvcScpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_SVC_SCP 테이블 조회
	  * </pre>
	  */
	public ServiceScopeDBDAOMdmSvcScpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.integration").append("\n"); 
		query.append("FileName : ServiceScopeDBDAOMdmSvcScpVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.SVC_SCP_NM" ).append("\n"); 
		query.append(", A.FMC_FILE_FLG" ).append("\n"); 
		query.append(", A.TRF_NO" ).append("\n"); 
		query.append(", A.CONF_FLG" ).append("\n"); 
		query.append(", A.SVC_SCP_BND_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.UPD_DT, 'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP A" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("#if (${org_tp_cd} == 'L')" ).append("\n"); 
		query.append("SELECT DISTINCT(B.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A" ).append("\n"); 
		query.append(", MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = @[org_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("AND B.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${org_tp_cd} == 'R')" ).append("\n"); 
		query.append("SELECT DISTINCT(SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LMT" ).append("\n"); 
		query.append("WHERE RGN_CD = @[org_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_tp_cd} == 'C')" ).append("\n"); 
		query.append("SELECT DISTINCT(C.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY A" ).append("\n"); 
		query.append(", MDM_REGION B" ).append("\n"); 
		query.append(", MDM_SVC_SCP_LMT C" ).append("\n"); 
		query.append("WHERE A.CNT_CD = @[org_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("AND C.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${org_tp_cd} == 'S')" ).append("\n"); 
		query.append("SELECT DISTINCT(D.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT A" ).append("\n"); 
		query.append(", MDM_COUNTRY B" ).append("\n"); 
		query.append(", MDM_REGION C" ).append("\n"); 
		query.append(", MDM_SVC_SCP_LMT D" ).append("\n"); 
		query.append("WHERE A.SCONTI_CD = @[org_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.SCONTI_CD = A.SCONTI_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND D.RGN_CD = C.RGN_CD" ).append("\n"); 
		query.append("AND D.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") O" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("#if (${dest_tp_cd} == 'L')" ).append("\n"); 
		query.append("SELECT DISTINCT(B.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A" ).append("\n"); 
		query.append(", MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = @[dest_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("AND B.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${dest_tp_cd} == 'R')" ).append("\n"); 
		query.append("SELECT DISTINCT(SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP_LMT" ).append("\n"); 
		query.append("WHERE RGN_CD = @[dest_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${dest_tp_cd} == 'C')" ).append("\n"); 
		query.append("SELECT DISTINCT(C.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY A" ).append("\n"); 
		query.append(", MDM_REGION B" ).append("\n"); 
		query.append(", MDM_SVC_SCP_LMT C" ).append("\n"); 
		query.append("WHERE A.CNT_CD = @[dest_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("AND C.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${dest_tp_cd} == 'S')" ).append("\n"); 
		query.append("SELECT DISTINCT(D.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT A" ).append("\n"); 
		query.append(", MDM_COUNTRY B" ).append("\n"); 
		query.append(", MDM_REGION C" ).append("\n"); 
		query.append(", MDM_SVC_SCP_LMT D" ).append("\n"); 
		query.append("WHERE A.SCONTI_CD = @[dest_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.SCONTI_CD = A.SCONTI_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND D.RGN_CD = C.RGN_CD" ).append("\n"); 
		query.append("AND D.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = O.SVC_SCP_CD" ).append("\n"); 
		query.append("AND O.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}