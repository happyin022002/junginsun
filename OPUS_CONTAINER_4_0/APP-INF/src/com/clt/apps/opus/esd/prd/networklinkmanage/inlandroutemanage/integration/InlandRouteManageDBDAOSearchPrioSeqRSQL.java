/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteManageDBDAOSearchPrioSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.12 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOSearchPrioSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPrioSeq
	  * </pre>
	  */
	public InlandRouteManageDBDAOSearchPrioSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_inbound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOSearchPrioSeqRSQL").append("\n"); 
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
		query.append("select max(rn) row_cnt," ).append("\n"); 
		query.append("MAX(DECODE ( cnt,1 ,nvl(prio_seq,0), 0) ) max_prio_seq" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT prio_seq, rout_org_nod_cd, rout_dest_nod_cd , rownum rn," ).append("\n"); 
		query.append("COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_mst m" ).append("\n"); 
		query.append("WHERE rout_org_nod_cd LIKE" ).append("\n"); 
		query.append("DECODE (@[r_inbound] ,  --B" ).append("\n"); 
		query.append("'I', @[i_rout_org_nod_cd], --'CNHKGCH'" ).append("\n"); 
		query.append("'O', SUBSTR ( @[i_rout_org_nod_cd], 1, 5) || '%', --'CNHKGCH'" ).append("\n"); 
		query.append("'B', SUBSTR ( @[i_rout_org_nod_cd], 1, 5) || '%', --'CNHKGCH'" ).append("\n"); 
		query.append("'M', SUBSTR ( @[i_rout_org_nod_cd], 1, 5) || '%' --'CNHKGHT'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND rout_dest_nod_cd LIKE" ).append("\n"); 
		query.append("DECODE ( @[r_inbound] ,  --B" ).append("\n"); 
		query.append("'I', SUBSTR (@[i_rout_org_dest_cd], 1, 5) || '%', --'CNHKGHT'" ).append("\n"); 
		query.append("'O', @[i_rout_org_dest_cd] , --'CNHKGHT'" ).append("\n"); 
		query.append("'B', SUBSTR (@[i_rout_org_dest_cd], 1, 5) || '%', --'CNHKGHT'" ).append("\n"); 
		query.append("'M', SUBSTR (@[i_rout_org_dest_cd], 1, 5) || '%' --'CNHKGHT'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = @[r_inbound]  --B" ).append("\n"); 
		query.append("AND NVL(m.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${r_inbound} == 'I')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM prd_node n WHERE n.nod_cd = M.ROUT_ORG_NOD_CD   AND n.nod_tp_cd IN ('M', 'B')   ) --I , ORG" ).append("\n"); 
		query.append("#if(${nod_tp_cd1} == 'Z')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM prd_node n WHERE n.nod_cd = M.rout_dest_nod_cd  AND n.nod_tp_cd ='Z'  ) --I,DEST, Z" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM prd_node n WHERE n.nod_cd = M.rout_dest_nod_cd  AND n.nod_tp_cd !='Z'  ) --I,DEST, !Z" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif(${r_inbound} == 'O')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM prd_node n WHERE n.nod_cd = M.rout_dest_nod_cd  AND n.nod_tp_cd IN ('M', 'B')   ) --O , DEST" ).append("\n"); 
		query.append("#if(${nod_tp_cd2} == 'Z')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM prd_node n WHERE n.nod_cd = M.ROUT_ORG_NOD_CD AND n.nod_tp_cd ='Z'  ) --O,ORG, Z" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM prd_node n WHERE n.nod_cd = M.ROUT_ORG_NOD_CD AND n.nod_tp_cd !='Z'  ) --O,ORG, !Z" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("group by substr(rout_org_nod_cd,1,5), substr(rout_dest_nod_cd,1,5)" ).append("\n"); 

	}
}