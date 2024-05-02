/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PendingListDBDAOSearchPendingListListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.04.04 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PendingListDBDAOSearchPendingListListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pending List Search
	  * </pre>
	  */
	public PendingListDBDAOSearchPendingListListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_transmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_cost",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.integration").append("\n"); 
		query.append("FileName : PendingListDBDAOSearchPendingListListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'FULL' cargo," ).append("\n"); 
		query.append("to_char(A.N1ST_NOD_PLN_DT,'YYYYMMDD') duedate," ).append("\n"); 
		query.append("decode(A.PCTL_IO_BND_CD,'O','Out','I','In')	bound," ).append("\n"); 
		query.append("C.VSL_CD truckvvd," ).append("\n"); 
		query.append("decode(SUBSTR(A.COST_ACT_GRP_CD,2,1),'Y','CY','D','DOOR')    cost," ).append("\n"); 
		query.append("decode(SUBSTR(A.COST_ACT_GRP_CD,3,2),'TD','Truck','RD','Rail','WT','WT','WR','WR') trans," ).append("\n"); 
		query.append("COUNT(A.CTRL_OFC_CD) qty" ).append("\n"); 
		query.append("FROM SCE_PLN_SO_LIST A, SCE_COP_HDR B, BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.TRSP_SO_STS_CD IN ('P')" ).append("\n"); 
		query.append("AND A.PCTL_COST_MOD_CD IN ('C', 'Z')" ).append("\n"); 
		query.append("#if (${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("AND A.N1ST_NOD_PLN_DT BETWEEN TO_DATE(@[from_date], 'YYYYMMDD') AND TO_DATE(@[to_date], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != 'ALL' && ${bound} != '' )" ).append("\n"); 
		query.append("AND A.PCTL_IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hid_cost} != 'ALL' && ${hid_cost} != '' )" ).append("\n"); 
		query.append("AND SUBSTR(A.COST_ACT_GRP_CD,2,1) = @[hid_cost]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sel_transmode} != 'ALL' && ${sel_transmode} != '' )" ).append("\n"); 
		query.append("AND SUBSTR(A.COST_ACT_GRP_CD,3,2) = @[sel_transmode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($OfcCd.size() > 0)" ).append("\n"); 
		query.append("AND   A.CTRL_OFC_CD  in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${OfcCd})" ).append("\n"); 
		query.append("#if($velocityCount < $OfcCd.size())" ).append("\n"); 
		query.append("UPPER('$key')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPPER('$key')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trunk_vvd} != '' )" ).append("\n"); 
		query.append("AND C.VSL_CD = @[trunk_vvd1]" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO = @[trunk_vvd2]" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD = @[trunk_vvd3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.COP_NO=B.COP_NO" ).append("\n"); 
		query.append("AND B.BKG_NO=C.BKG_NO" ).append("\n"); 
		query.append("GROUP BY to_char(A.N1ST_NOD_PLN_DT,'YYYYMMDD'),decode(A.PCTL_IO_BND_CD,'O','Out','I','In')," ).append("\n"); 
		query.append("C.VSL_CD,decode(SUBSTR(A.COST_ACT_GRP_CD,2,1),'Y','CY','D','DOOR')," ).append("\n"); 
		query.append("decode(SUBSTR(A.COST_ACT_GRP_CD,3,2),'TD','Truck','RD','Rail','WT','WT','WR','WR')" ).append("\n"); 
		query.append("ORDER BY to_char(A.N1ST_NOD_PLN_DT,'YYYYMMDD'),decode(A.PCTL_IO_BND_CD,'O','Out','I','In')," ).append("\n"); 
		query.append("C.VSL_CD,decode(SUBSTR(A.COST_ACT_GRP_CD,2,1),'Y','CY','D','DOOR')," ).append("\n"); 
		query.append("decode(SUBSTR(A.COST_ACT_GRP_CD,3,2),'TD','Truck','RD','Rail','WT','WT','WR','WR')" ).append("\n"); 

	}
}