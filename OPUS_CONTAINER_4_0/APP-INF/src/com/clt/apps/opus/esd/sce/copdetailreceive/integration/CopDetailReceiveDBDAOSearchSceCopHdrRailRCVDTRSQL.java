/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchSceCopHdrRailRCVDTRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchSceCopHdrRailRCVDTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSceCopHdrRailRCVDT
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchSceCopHdrRailRCVDTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchSceCopHdrRailRCVDTRSQL").append("\n"); 
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
		query.append("SELECT cop_no" ).append("\n"); 
		query.append(", TO_CHAR(rail_rcv_coff_fm_dt,'YYYYMMDDHH24MISS') rail_rcv_coff_fm_dt" ).append("\n"); 
		query.append(", TO_CHAR(rail_rcv_coff_to_dt,'YYYYMMDDHH24MISS') rail_rcv_coff_to_dt" ).append("\n"); 
		query.append("FROM (                          " ).append("\n"); 
		query.append("SELECT A.cop_no, (A.RAIL_RCV_COFF_FM_DT+NUMTODSINTERVAL((TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')-A.VPS_EVNT_DT),'DAY')) rail_rcv_coff_fm_dt " ).append("\n"); 
		query.append("               , (A.RAIL_RCV_COFF_TO_DT+NUMTODSINTERVAL((TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')-A.VPS_EVNT_DT),'DAY')) rail_rcv_coff_to_dt " ).append("\n"); 
		query.append("       ,NUMTODSINTERVAL((TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')-A.VPS_EVNT_DT),'DAY') gap " ).append("\n"); 
		query.append("FROM   (SELECT H.COP_NO,H.RAIL_RCV_COFF_FM_DT,H.RAIL_RCV_COFF_TO_DT" ).append("\n"); 
		query.append("               ,S.VPS_EVNT_DT,S.VPS_RCV_DT,S.VPS_RCV_NO " ).append("\n"); 
		query.append("               ,RANK() OVER (PARTITION BY H.COP_NO ORDER BY S.VPS_RCV_DT DESC, S.VPS_RCV_NO DESC) RANK_DT " ).append("\n"); 
		query.append("        FROM   SCE_COP_DTL D, SCE_COP_HDR H, SCE_SVC_PTAL_VPS_IF S   --, BKG_BL_ISS O " ).append("\n"); 
		query.append("        WHERE  D.VSL_CD                = @[vsl_cd]   " ).append("\n"); 
		query.append("        AND    D.SKD_VOY_NO            = @[skd_voy_no]  " ).append("\n"); 
		query.append("        AND    D.SKD_DIR_CD            = @[skd_dir_cd]   " ).append("\n"); 
		query.append("        AND    D.VPS_PORT_CD           = @[vps_port_cd] " ).append("\n"); 
		query.append("        AND    NVL(D.CLPT_IND_SEQ,'1') = NVL(@[clpt_ind_seq],'1') " ).append("\n"); 
		query.append("        AND    D.STND_EDI_STS_CD       = 'AEL' " ).append("\n"); 
		query.append("        AND    H.COP_NO                = D.COP_NO " ).append("\n"); 
		query.append("        AND    H.COP_STS_CD            IN ('C','T') " ).append("\n"); 
		query.append("        AND    S.VSL_CD                = D.VSL_CD " ).append("\n"); 
		query.append("        AND    S.SKD_VOY_NO            = D.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND    S.SKD_DIR_CD            = D.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND    S.VPS_PORT_CD           = D.VPS_PORT_CD " ).append("\n"); 
		query.append("        AND    S.CLPT_IND_SEQ          = D.CLPT_IND_SEQ " ).append("\n"); 
		query.append("        AND    S.VPS_EVNT_TP_CD        = 'ETA') A " ).append("\n"); 
		query.append("WHERE  A.RANK_DT = 2         " ).append("\n"); 
		query.append("AND    (" ).append("\n"); 
		query.append("         TO_CHAR(A.RAIL_RCV_COFF_FM_DT,'MMDD') <> TO_CHAR(A.RAIL_RCV_COFF_FM_DT+NUMTODSINTERVAL((TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')-A.VPS_EVNT_DT),'DAY'),'MMDD')" ).append("\n"); 
		query.append("         OR TO_CHAR(A.RAIL_RCV_COFF_TO_DT,'MMDD') <> TO_CHAR(A.RAIL_RCV_COFF_TO_DT+NUMTODSINTERVAL((TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')-A.VPS_EVNT_DT),'DAY'),'MMDD')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("WHERE S.gap IS NOT NULL" ).append("\n"); 

	}
}