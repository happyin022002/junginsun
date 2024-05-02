/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwellTotalCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.07.03 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwellTotalCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dwell Type별 Total count 조회
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwellTotalCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sent",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_so_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_dest",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwellTotalCntRSQL").append("\n"); 
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
		query.append("SELECT BB.Tab1Total as Tab1Total" ).append("\n"); 
		query.append(",BB.Tab2Total as Tab2Total" ).append("\n"); 
		query.append(",BB.Tab3Total as Tab3Total" ).append("\n"); 
		query.append(",BB.Tab4Total as Tab4Total" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(DECODE(AA.DWLL_TM_TP_CD, 'T96', 1, 0)) Tab1Total" ).append("\n"); 
		query.append(",SUM(DECODE(AA.DWLL_TM_TP_CD, 'E48', 1, 0)) Tab2Total" ).append("\n"); 
		query.append(",SUM(DECODE(AA.DWLL_TM_TP_CD, 'D72', 1, 0)) Tab3Total" ).append("\n"); 
		query.append(",SUM(DECODE(AA.DWLL_TM_TP_CD, 'V24', 1, 0)) Tab4Total" ).append("\n"); 
		query.append(",GROUPING(AA.DWLL_TM_TP_CD) GR_CHK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.DWLL_TM_TP_CD" ).append("\n"); 
		query.append(", NVL( (SELECT 'Y' FROM SCE_DWLL_NTFC_EML_SND_HIS B WHERE A.EML_SND_DT = B.EML_SND_DT AND A.SC_NO = B.SC_NO AND ROWNUM = 1),'N') SND_STS" ).append("\n"); 
		query.append("FROM SCE_DWLL_NTFC_HIS A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.EML_SND_DT = (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC', TO_DATE(@[search_dt] ||'0300', 'YYYYMMDDHH24MI'), 'KRPUS'), 'YYYYMMDD') FROM DUAL)" ).append("\n"); 
		query.append("#if(${rail_dest} != '')" ).append("\n"); 
		query.append("AND A.RAIL_DEST_YD_CD LIKE @[rail_dest] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($scNoArr.size() > 0)" ).append("\n"); 
		query.append("AND SUBSTR(A.SC_NO, 0,3) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${scNoArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_no} != '')" ).append("\n"); 
		query.append("AND A.SC_NO LIKE CASE WHEN ASCII(SUBSTR(@[sc_no],1,1)) BETWEEN 48 AND 57 THEN '___' END || @[sc_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pod_cd} != '')" ).append("\n"); 
		query.append("and A.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${del_cd} != '')" ).append("\n"); 
		query.append("and A.DEL_CD LIKE @[del_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM SCE_DWLL_NTFC_CUST C WHERE 1=1" ).append("\n"); 
		query.append("AND A.EML_SND_DT = C.EML_SND_DT" ).append("\n"); 
		query.append("AND A.DWLL_TM_TP_CD = C.DWLL_TM_TP_CD" ).append("\n"); 
		query.append("AND A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND C.CUST_CNT_CD LIKE SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND C.CUST_SEQ LIKE TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vvd} != '')" ).append("\n"); 
		query.append("and A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("and A.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '')" ).append("\n"); 
		query.append("and A.BKG_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("and A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and A.RAIL_SO_FLG = NVL(@[rail_so_flg], A.RAIL_SO_FLG)" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("#if(${sent} == 'Y' )" ).append("\n"); 
		query.append("WHERE AA.SND_STS = @[sent]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY ROLLUP(AA.DWLL_TM_TP_CD)" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE GR_CHK = '1'" ).append("\n"); 

	}
}