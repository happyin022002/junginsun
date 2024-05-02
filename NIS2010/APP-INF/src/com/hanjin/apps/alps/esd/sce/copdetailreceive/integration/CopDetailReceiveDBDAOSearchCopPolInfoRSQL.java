/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopPolInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.29 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopPolInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopPolInfo
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopPolInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopPolInfoRSQL").append("\n"); 
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
		query.append("SELECT A.COP_NO, (A.RAIL_RCV_COFF_FM_DT+NUMTODSINTERVAL((TO_DATE(@[in_act_dt],'YYYY/MM/DD HH24:MI:SS')-A.VPS_EVNT_DT),'DAY')) RAIL_RCV_COFF_FM_DT" ).append("\n"); 
		query.append(",NUMTODSINTERVAL((TO_DATE(@[in_act_dt],'YYYY/MM/DD HH24:MI:SS')-A.VPS_EVNT_DT),'DAY') GAP" ).append("\n"); 
		query.append("FROM   (SELECT H.COP_NO,NVL(H.RAIL_RCV_COFF_FM_DT,O.RAIL_RCV_COFF_FM_DT) RAIL_RCV_COFF_FM_DT" ).append("\n"); 
		query.append(",S.VPS_EVNT_DT,S.VPS_RCV_DT,S.VPS_RCV_NO" ).append("\n"); 
		query.append(",RANK() OVER (PARTITION BY H.COP_NO ORDER BY S.VPS_RCV_DT DESC, S.VPS_RCV_NO DESC) RANK_DT" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL D, SCE_COP_HDR H, SCE_SVC_PTAL_VPS_IF S, BKG_BL_ISS O" ).append("\n"); 
		query.append("WHERE  D.VSL_CD                = @[in_vsl_cd]" ).append("\n"); 
		query.append("AND    D.SKD_VOY_NO            = @[in_skd_voy_no]" ).append("\n"); 
		query.append("AND    D.SKD_DIR_CD            = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("AND    D.VPS_PORT_CD           = @[in_vps_port_cd]" ).append("\n"); 
		query.append("AND    NVL(D.CLPT_IND_SEQ,'1') = NVL(@[in_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("AND    D.STND_EDI_STS_CD       = 'AEL'" ).append("\n"); 
		query.append("AND    H.COP_NO                = D.COP_NO" ).append("\n"); 
		query.append("AND    H.COP_STS_CD            IN ('C','T')" ).append("\n"); 
		query.append("AND    O.BKG_NO                = H.BKG_NO" ).append("\n"); 
		query.append("AND    O.RAIL_RCV_COFF_FM_DT   IS NOT NULL" ).append("\n"); 
		query.append("AND    S.VSL_CD                = D.VSL_CD" ).append("\n"); 
		query.append("AND    S.SKD_VOY_NO            = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    S.SKD_DIR_CD            = D.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    S.VPS_PORT_CD           = D.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    S.CLPT_IND_SEQ          = D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND    S.VPS_EVNT_TP_CD        = 'ETA') A" ).append("\n"); 
		query.append("WHERE  A.RANK_DT = 2" ).append("\n"); 
		query.append("AND    TO_CHAR(A.RAIL_RCV_COFF_FM_DT,'MMDD') <> TO_CHAR(A.RAIL_RCV_COFF_FM_DT+NUMTODSINTERVAL((TO_DATE(@[in_act_dt],'YYYY/MM/DD HH24:MI:SS')-A.VPS_EVNT_DT),'DAY'),'MMDD')" ).append("\n"); 

	}
}