/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InlandRouteManageDBDAOUpdateHubLocUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.29
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.06.29 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOUpdateHubLocUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateHubLoc
	  * US,CA,MX에만 적용하던 USA Full이 America Continent로 확장됨에 따라 SUBQUERY 추가
	  * </pre>
	  */
	public InlandRouteManageDBDAOUpdateHubLocUSQL(){
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
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOUpdateHubLocUSQL").append("\n"); 
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
		query.append("UPDATE prd_inlnd_rout_mst mst " ).append("\n"); 
		query.append("SET HUB_NOD_CD =  ( " ).append("\n"); 
		query.append("                    select HUB -- substr(hub,1,5) " ).append("\n"); 
		query.append("                    from ( " ).append("\n"); 
		query.append("                            select  ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD, ROUT_SEQ, hub " ).append("\n"); 
		query.append("                            from " ).append("\n"); 
		query.append("                            ( " ).append("\n"); 
		query.append("                                select " ).append("\n"); 
		query.append("                                    ROUT_ORG_NOD_CD, ROUT_dest_NOD_CD, ROUT_SEQ , " ).append("\n"); 
		query.append("                                    cnt, PCTL_IO_BND_CD , " ).append("\n"); 
		query.append("                                    decode(PCTL_IO_BND_CD,'O',first_value(LNK_ORG_NOD_CD) over(partition by ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ ), " ).append("\n"); 
		query.append("                                                          'I',last_value(LNK_DEST_NOD_CD) over(partition by ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ ) " ).append("\n"); 
		query.append("                                          ) hub " ).append("\n"); 
		query.append("                                from " ).append("\n"); 
		query.append("                                ( " ).append("\n"); 
		query.append("                                    select m.ROUT_ORG_NOD_CD,m.ROUT_DEST_NOD_CD,m.ROUT_SEQ,LNK_ORG_NOD_CD,LNK_DEST_NOD_CD,ROUT_DTL_SEQ,PCTL_IO_BND_CD, " ).append("\n"); 
		query.append("                                        COUNT (*) OVER (PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq " ).append("\n"); 
		query.append("                                                               ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt , " ).append("\n"); 
		query.append("                                        row_number() over (partition by  m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq " ).append("\n"); 
		query.append("                                                               ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS rn " ).append("\n"); 
		query.append("                                    from prd_inlnd_rout_mst m, prd_inlnd_rout_dtl d " ).append("\n"); 
		query.append("                                    where m.ROUT_ORG_NOD_CD= d.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("                                    and m.ROUT_DEST_NOD_CD = d.ROUT_DEST_NOD_CD " ).append("\n"); 
		query.append("                                    and m.ROUT_SEQ = d.ROUT_SEQ " ).append("\n"); 
		query.append("                                    AND EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                                                 FROM MDM_SUBCONTINENT CONT" ).append("\n"); 
		query.append("                                                      , MDM_COUNTRY MCNT" ).append("\n"); 
		query.append("                                                  WHERE CONT.CONTI_CD = 'M'" ).append("\n"); 
		query.append("                                                    AND MCNT.SCONTI_CD(+) = CONT.SCONTI_CD" ).append("\n"); 
		query.append("                                                    AND MCNT.CNT_CD = SUBSTR(M.ROUT_ORG_NOD_CD,1,2) " ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                                    and d.TRSP_MOD_CD ='RD' " ).append("\n"); 
		query.append("                                    AND m.ROUT_ORG_NOD_CD= @[i_rout_org_nod_cd] " ).append("\n"); 
		query.append("                                    and m.ROUT_DEST_NOD_CD = @[i_rout_dest_nod_cd] " ).append("\n"); 
		query.append("                                    and m.ROUT_SEQ= to_number(@[i_rout_seq]) " ).append("\n"); 
		query.append("                                    and NVL(m.DELT_FLG,'N') ='N' " ).append("\n"); 
		query.append("                                    and m.PCTL_IO_BND_CD in ('I','O') " ).append("\n"); 
		query.append("                                ) " ).append("\n"); 
		query.append("                                order by ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,ROUT_DTL_SEQ " ).append("\n"); 
		query.append("                            ) " ).append("\n"); 
		query.append("                            group by ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,hub --,F,L " ).append("\n"); 
		query.append("                    ) hub " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("where mst.ROUT_ORG_NOD_CD = @[i_rout_org_nod_cd] " ).append("\n"); 
		query.append("and   mst.ROUT_DEST_NOD_CD= @[i_rout_dest_nod_cd] " ).append("\n"); 
		query.append("and   mst.ROUT_SEQ = to_number(@[i_rout_seq])" ).append("\n"); 

	}
}