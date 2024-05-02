/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopDetailCurrentStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopDetailCurrentStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopDetailCurrentStatus
	  * 1. pseudo yard 에 대한 MVMT 정보 mapping 로직 변경 ( SQL문 수정 )
	  *  - 'MT', decode(substr(a.nod_cd, 3, 3),'XXX',substr(a.nod_cd, 1, 2),a.nod_cd),
	  *  - 'MT', decode(substr(@[nod_cd], 3, 3),'XXX',substr(@[nod_cd], 1, 2),a.nod_cd)
	  * 2. 2011-03-28 권상준 추가
	  *  - 'IC' 일때 , ID,EN,TN 추가
	  *    1) Yard까지 동일한 경우 최우선 사용.
	  *    2) 단, Yard 동일 건이 없으면 location 동일 activity에 mapping 
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopDetailCurrentStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_itchg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopDetailCurrentStatusRSQL").append("\n"); 
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
		query.append("SELECT a.cop_no" ).append("\n"); 
		query.append(",a.cop_dtl_seq" ).append("\n"); 
		query.append(",a.nod_cd" ).append("\n"); 
		query.append(",a.act_sts_cd" ).append("\n"); 
		query.append(",b.act_rcv_tp_cd" ).append("\n"); 
		query.append(",b.act_sts_mapg_cd" ).append("\n"); 
		query.append(",a.vsl_cd" ).append("\n"); 
		query.append(",a.skd_voy_no" ).append("\n"); 
		query.append(",a.skd_dir_cd" ).append("\n"); 
		query.append(",a.stnd_edi_sts_cd" ).append("\n"); 
		query.append(",a.act_cd" ).append("\n"); 
		query.append(",to_char(a.act_dt,'YYYYMMDDHH24MISS') AS act_dt" ).append("\n"); 
		query.append("#if (${act_sts_mapg_cd} == 'IC' || ${act_sts_mapg_cd} == 'ID' || ${act_sts_mapg_cd} == 'EN' || ${act_sts_mapg_cd} == 'TN')" ).append("\n"); 
		query.append(",( CASE WHEN @[nod_cd] = a.nod_cd" ).append("\n"); 
		query.append("and act_sts_cd = 'C' then '1'" ).append("\n"); 
		query.append("WHEN @[nod_cd] = a.nod_cd" ).append("\n"); 
		query.append("and act_sts_cd != 'C' then '2'" ).append("\n"); 
		query.append("WHEN substr(@[nod_cd], 1, 5) = substr(a.nod_cd, 1, 5)" ).append("\n"); 
		query.append("and act_sts_cd = 'C' then '3'" ).append("\n"); 
		query.append("WHEN substr(@[nod_cd], 1, 5) = substr(a.nod_cd, 1, 5)" ).append("\n"); 
		query.append("and act_sts_cd != 'C' then '4'" ).append("\n"); 
		query.append("else '5' end ) as lvl" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",( CASE WHEN @[act_sts_mapg_cd] = 'VL' and (a.vsl_cd, a.skd_voy_no, a.skd_dir_cd) in ( (@[vsl_cd], @[skd_voy_no], @[skd_dir_cd]))" ).append("\n"); 
		query.append("and act_sts_cd = 'C' then '1'" ).append("\n"); 
		query.append("WHEN @[act_sts_mapg_cd] = 'VL' and (a.vsl_cd, a.skd_voy_no, a.skd_dir_cd) in ( (@[vsl_cd], @[skd_voy_no], @[skd_dir_cd]))" ).append("\n"); 
		query.append("and act_sts_cd != 'C' then '2'" ).append("\n"); 
		query.append("WHEN @[act_sts_mapg_cd] = 'VL' and (a.vsl_cd, a.skd_voy_no, a.skd_dir_cd) not in ( (@[vsl_cd], @[skd_voy_no], @[skd_dir_cd]))" ).append("\n"); 
		query.append("and act_sts_cd = 'C' then '3'" ).append("\n"); 
		query.append("WHEN @[act_sts_mapg_cd] = 'VL' and (a.vsl_cd, a.skd_voy_no, a.skd_dir_cd) not in ( (@[vsl_cd], @[skd_voy_no], @[skd_dir_cd]))" ).append("\n"); 
		query.append("and act_sts_cd != 'C' then '4'" ).append("\n"); 
		query.append("WHEN ((@[act_sts_mapg_cd] = 'VL' and @[vsl_cd] = '' and @[skd_voy_no] = '' and @[skd_dir_cd] = '') or @[act_sts_mapg_cd] != 'VL')" ).append("\n"); 
		query.append("and act_sts_cd = 'C' then '5'" ).append("\n"); 
		query.append("WHEN ((@[act_sts_mapg_cd] = 'VL' and @[vsl_cd] = '' and @[skd_voy_no] = '' and @[skd_dir_cd] = '') or @[act_sts_mapg_cd] != 'VL')" ).append("\n"); 
		query.append("and act_sts_cd != 'C' then '6'" ).append("\n"); 
		query.append("else '7' end ) as lvl" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",c.rpln_bat_snd_flg" ).append("\n"); 
		query.append("FROM   sce_cop_dtl a" ).append("\n"); 
		query.append(",sce_act_act_mapg b" ).append("\n"); 
		query.append(",edi_cgo_stnd_sts c" ).append("\n"); 
		query.append("WHERE  a.cop_no          = @[cop_no]" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C'" ).append("\n"); 
		query.append("AND    CASE WHEN @[act_sts_mapg_cd] = 'VL' and (a.vsl_cd, a.skd_voy_no, a.skd_dir_cd) in ( (@[vsl_cd], @[skd_voy_no], @[skd_dir_cd])) THEN 'TRUE'" ).append("\n"); 
		query.append("WHEN @[act_sts_mapg_cd] != 'VL' THEN 'TRUE'" ).append("\n"); 
		query.append("ELSE 'FALSE' END = 'TRUE'" ).append("\n"); 
		query.append("AND    (" ).append("\n"); 
		query.append("(decode(  b.act_sts_mapg_cd, 'VL', substr(a.nod_cd, 1, 5)," ).append("\n"); 
		query.append("'VD', substr(a.nod_cd, 1, 5)," ).append("\n"); 
		query.append("'AL', substr(a.nod_cd, 1, 5)," ).append("\n"); 
		query.append("'UR', substr(a.nod_cd, 1, 5)," ).append("\n"); 
		query.append("'AR', decode(SUBSTR(a.nod_cd,1,2),'US',substr(a.nod_cd, 1, 5),'CA',substr(a.nod_cd, 1, 5), a.nod_cd)," ).append("\n"); 
		query.append("'RL', decode(SUBSTR(a.nod_cd,1,2),'US',substr(a.nod_cd, 1, 5),'CA',substr(a.nod_cd, 1, 5), a.nod_cd)," ).append("\n"); 
		query.append("'A', decode(b.rail_itchg_flg, 'Y', substr(a.nod_cd, 1, 5), a.nod_cd),			-- CHM-201324593 : Added" ).append("\n"); 
		query.append("'P', decode(b.rail_itchg_flg, 'Y', substr(a.nod_cd, 1, 5), a.nod_cd),			-- CHM-201324593 : Added" ).append("\n"); 
		query.append("'J', decode(b.rail_itchg_flg, 'Y', substr(a.nod_cd, 1, 5), a.nod_cd),			-- CHM-201324593 : Added" ).append("\n"); 
		query.append("'R', decode(b.rail_itchg_flg, 'Y', substr(a.nod_cd, 1, 5), a.nod_cd),			-- CHM-201324593 : Added" ).append("\n"); 
		query.append("a.nod_cd)" ).append("\n"); 
		query.append("= decode(@[act_sts_mapg_cd]," ).append("\n"); 
		query.append("'VL', substr(@[nod_cd], 1, 5)," ).append("\n"); 
		query.append("'VD', substr(@[nod_cd], 1, 5)," ).append("\n"); 
		query.append("'AL', substr(@[nod_cd], 1, 5)," ).append("\n"); 
		query.append("'UR', substr(@[nod_cd], 1, 5)," ).append("\n"); 
		query.append("'AR', decode(SUBSTR(@[nod_cd],1,2),'US',substr(@[nod_cd], 1, 5),'CA',substr(a.nod_cd, 1, 5), @[nod_cd])," ).append("\n"); 
		query.append("'RL', decode(SUBSTR(@[nod_cd],1,2),'US',substr(@[nod_cd], 1, 5),'CA',substr(a.nod_cd, 1, 5), @[nod_cd])," ).append("\n"); 
		query.append("'A', decode(b.rail_itchg_flg, 'Y', substr(@[nod_cd], 1, 5), @[nod_cd]),			-- CHM-201324593 : Added" ).append("\n"); 
		query.append("'P', decode(b.rail_itchg_flg, 'Y', substr(@[nod_cd], 1, 5), @[nod_cd]),			-- CHM-201324593 : Added" ).append("\n"); 
		query.append("'J', decode(b.rail_itchg_flg, 'Y', substr(@[nod_cd], 1, 5), @[nod_cd]),			-- CHM-201324593 : Added" ).append("\n"); 
		query.append("'R', decode(b.rail_itchg_flg, 'Y', substr(@[nod_cd], 1, 5), @[nod_cd]),			-- CHM-201324593 : Added" ).append("\n"); 
		query.append("@[nod_cd])" ).append("\n"); 
		query.append(") or" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("a.cop_dtl_seq > 6000" ).append("\n"); 
		query.append("and" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("decode(b.act_sts_mapg_cd, 'IC', substr(a.nod_cd, 1, 5)," ).append("\n"); 
		query.append("'ID', substr(a.nod_cd, 1, 5)," ).append("\n"); 
		query.append("'EN', substr(a.nod_cd, 1, 5)," ).append("\n"); 
		query.append("'TN', substr(a.nod_cd, 1, 5)," ).append("\n"); 
		query.append("'MT', decode(substr(a.nod_cd, 3, 3),'XXX',substr(a.nod_cd, 1, 2),a.nod_cd), a.nod_cd )" ).append("\n"); 
		query.append("= decode(@[act_sts_mapg_cd], 'IC', substr(@[nod_cd], 1, 5)," ).append("\n"); 
		query.append("'ID', substr(@[nod_cd], 1, 5)," ).append("\n"); 
		query.append("'EN', substr(@[nod_cd], 1, 5)," ).append("\n"); 
		query.append("'TN', substr(@[nod_cd], 1, 5)," ).append("\n"); 
		query.append("'MT', decode(substr(@[nod_cd], 3, 3),'XXX',substr(@[nod_cd], 1, 2),@[nod_cd]) ,  @[nod_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND    a.act_cd          = b.act_cd" ).append("\n"); 
		query.append("AND    b.act_rcv_tp_cd   = @[act_rcv_tp_cd]" ).append("\n"); 
		query.append("AND    b.act_sts_mapg_cd = @[act_sts_mapg_cd]" ).append("\n"); 
		query.append("AND	   b.rail_itchg_flg	 = DECODE( b.act_sts_mapg_cd,	'AR', b.rail_itchg_flg," ).append("\n"); 
		query.append("'RL', b.rail_itchg_flg," ).append("\n"); 
		query.append("NVL(@[rail_itchg_flg],'N'))	 -- CHM-201324593 : Added --" ).append("\n"); 
		query.append("AND    a.stnd_edi_sts_cd = c.edi_stnd_sts_cd (+) -- 20121129 By SBKIM" ).append("\n"); 
		query.append("order by lvl, a.cop_dtl_seq" ).append("\n"); 

	}
}