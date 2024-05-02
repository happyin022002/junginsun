/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalInformationMgtDBDAOVskPortFltgCrnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationMgtDBDAOVskPortFltgCrnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalInformationMgtDBDAOVskPortFltgCrnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationMgtDBDAOVskPortFltgCrnVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.LOC_CD" ).append("\n"); 
		query.append(",	CRN_SEQ" ).append("\n"); 
		query.append(",	ROW_NUMBER() OVER (PARTITION BY A.LOC_CD ORDER BY A.LOC_CD, A.CRN_SEQ) CRN_VIEW_SEQ" ).append("\n"); 
		query.append(",	MAX_HNDL_CGO_WGT" ).append("\n"); 
		query.append(",	MAX_HNDL_CGO_HGT" ).append("\n"); 
		query.append(",	MAX_RCH_LEN" ).append("\n"); 
		query.append(",	HNDL_COST_RMK" ).append("\n"); 
		query.append(",	FLTG_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(a.UPD_DT, 'YYYY-MM-DD HH24:MI') as UPD_DT" ).append("\n"); 
		query.append("FROM VSK_PORT_FLTG_CRN	A," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("              SELECT    MX.LOC_CD" ).append("\n"); 
		query.append("                     ,  (" ).append("\n"); 
		query.append("                        SELECT    MAX(DECODE(MO.OFC_TP_CD, 'HQ', MO.OFC_CD))--  AS VAL    " ).append("\n"); 
		query.append("                            FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                            CONNECT BY   NOCYCLE PRIOR MO.PRNT_OFC_CD  = MO.OFC_CD" ).append("\n"); 
		query.append("                            START WITH   MO.OFC_CD             = MX.SLS_OFC_CD" ).append("\n"); 
		query.append("                        ) AS POR_RHQ" ).append("\n"); 
		query.append("            FROM      MDM_LOCATION       MX " ).append("\n"); 
		query.append("          WHERE      MX.CALL_PORT_FLG    = 'Y'" ).append("\n"); 
		query.append("          AND        MX.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	)B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND B.POR_RHQ LIKE @[por_rhq]" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND	A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.LOC_CD,	A.CRN_SEQ" ).append("\n"); 

	}
}