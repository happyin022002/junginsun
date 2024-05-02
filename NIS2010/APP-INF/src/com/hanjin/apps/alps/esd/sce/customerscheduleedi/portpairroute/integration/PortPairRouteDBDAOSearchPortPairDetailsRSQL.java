/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairRouteDBDAOSearchPortPairDetailsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairRouteDBDAOSearchPortPairDetailsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPortPairDetails
	  * </pre>
	  */
	public PortPairRouteDBDAOSearchPortPairDetailsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("partner_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("no_use_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.integration").append("\n"); 
		query.append("FileName : PortPairRouteDBDAOSearchPortPairDetailsRSQL").append("\n"); 
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
		query.append("		 ROUT_RCV_DT                                      " ).append("\n"); 
		query.append("		,ROUT_SEQ                                         " ).append("\n"); 
		query.append("		,CUST_TRD_PRNR_ID                               		" ).append("\n"); 
		query.append("		,POR_CD                                           " ).append("\n"); 
		query.append("		,ORG_LOC_CD AS POL_CD                            " ).append("\n"); 
		query.append("		,N1ST_POL_CD                                      " ).append("\n"); 
		query.append("		,N1ST_POD_CD                                      " ).append("\n"); 
		query.append("		,N2ND_POL_CD                                      " ).append("\n"); 
		query.append("		,N2ND_POD_CD                                      " ).append("\n"); 
		query.append("		,N3RD_POL_CD                                      " ).append("\n"); 
		query.append("		,N3RD_POD_CD                                      " ).append("\n"); 
		query.append("		,N4TH_POL_CD                                      " ).append("\n"); 
		query.append("		,N4TH_POD_CD                                      " ).append("\n"); 
		query.append("		,DEST_LOC_CD AS POD_CD                                                                                    " ).append("\n"); 
		query.append("		,DEL_CD                                             " ).append("\n"); 
		query.append("		,UPD_IND_CD AS OCEAN_FLAG                             " ).append("\n"); 
		query.append("		,USE_FLG                                              " ).append("\n"); 
		query.append("		,MNL_USE_FLG" ).append("\n"); 
		query.append("		,'' AS DELT_FLG                                          " ).append("\n"); 
		query.append("		,CRE_USR_ID                                           " ).append("\n"); 
		query.append("		,TO_CHAR(CRE_DT, 'YYYYMMDDHH24MI') AS CRE_DT          " ).append("\n"); 
		query.append("		,DECODE(MNL_USE_FLG,'N',UPD_USR_ID,'')AS UPD_USR_ID                                 " ).append("\n"); 
		query.append("		,DECODE(MNL_USE_FLG,'N',TO_CHAR(UPD_DT, 'YYYYMMDDHH24MI'),'') AS UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- CHM-201326574 : added ------------>" ).append("\n"); 
		query.append("		," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	WM_CONCAT(SLAN_CD)" ).append("\n"); 
		query.append("			FROM	SCE_CUST_EDI_BLCK B" ).append("\n"); 
		query.append("			WHERE	B.ROUT_RCV_DT	=	DTL.ROUT_RCV_DT	" ).append("\n"); 
		query.append("			AND		B.ROUT_SEQ	    =	DTL.ROUT_SEQ " ).append("\n"); 
		query.append("            AND     B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		)	BLOCK_LANES " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		--<-------------- -- CHM-201326574 : added" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("FROM	SCE_PORT_PAIR_DTL DTL" ).append("\n"); 
		query.append("WHERE	CUST_TRD_PRNR_ID =  @[partner_id] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - POR */" ).append("\n"); 
		query.append("#if (${por_port_cd} != '') " ).append("\n"); 
		query.append("	AND		POR_CD			=	@[por_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("/* condition - POL */" ).append("\n"); 
		query.append("#if (${pol_port_cd} != '') " ).append("\n"); 
		query.append("	AND		N1ST_POL_CD		=    @[pol_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - POD */" ).append("\n"); 
		query.append("#if (${pod_port_cd} != '')  " ).append("\n"); 
		query.append("	AND		DEST_LOC_CD		=    @[pod_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* condition - DEL */" ).append("\n"); 
		query.append("#if (${del_port_cd} != '') " ).append("\n"); 
		query.append("	AND		DEL_CD			=	 @[del_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("	AND CASE	WHEN @[no_use_flag] = 'Y' AND NVL(mnl_use_flg,'Y') = 'Y' AND use_flg = 'Y'  " ).append("\n"); 
		query.append("						THEN 'Y'                                        " ).append("\n"); 
		query.append("				WHEN @[no_use_flag] = 'N' -- AND (mnl_use_flg = 'N' OR use_flg = 'N')  AND mnl_use_flg = 'N'" ).append("\n"); 
		query.append("						THEN 'Y'                                        " ).append("\n"); 
		query.append("		ELSE 'N'                                        " ).append("\n"); 
		query.append("		END			=	'Y'                                            " ).append("\n"); 
		query.append("	AND CASE	WHEN @[ts_type] = 'A'                                   " ).append("\n"); 
		query.append("						THEN 'Y'                                        " ).append("\n"); 
		query.append("				WHEN @[ts_type] = 'D' AND n2nd_pod_cd IS NULL AND n3rd_pod_cd IS NULL AND n4th_pod_cd IS NULL            " ).append("\n"); 
		query.append("						THEN 'Y'                                        " ).append("\n"); 
		query.append("				WHEN @[ts_type] = 'T' AND ( n2nd_pod_cd IS NOT NULL OR n3rd_pod_cd IS NOT NULL)           " ).append("\n"); 
		query.append("						THEN 'Y'                                        " ).append("\n"); 
		query.append("		ELSE 'N'                                        " ).append("\n"); 
		query.append("		END			=	'Y'" ).append("\n"); 

	}
}