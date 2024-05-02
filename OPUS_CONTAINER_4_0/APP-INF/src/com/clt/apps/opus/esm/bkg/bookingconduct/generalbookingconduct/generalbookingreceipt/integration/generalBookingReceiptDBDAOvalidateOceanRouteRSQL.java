/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : generalBookingReceiptDBDAOvalidateOceanRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.21
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.21 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class generalBookingReceiptDBDAOvalidateOceanRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규 route로 변경 가능한지 확인한다.
	  * </pre>
	  */
	public generalBookingReceiptDBDAOvalidateOceanRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : generalBookingReceiptDBDAOvalidateOceanRouteRSQL").append("\n"); 
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
		query.append("select (select count(1) route_count" ).append("\n"); 
		query.append("from prd_ocn_rout" ).append("\n"); 
		query.append("where org_loc_cd   = @[pol]" ).append("\n"); 
		query.append("and dest_loc_cd  = @[pod]" ).append("\n"); 
		query.append("and upd_ind_Cd   <> 'D'" ).append("\n"); 
		query.append("AND NVL(UPD_IND_CD,'S') IN ('C','U','S','T','A','V','G')" ).append("\n"); 
		query.append("and N1ST_POL_CD  = NVL(@[pol1], N1ST_POL_CD)" ).append("\n"); 
		query.append("and N1ST_POD_CD  = NVL(@[pod1], N1ST_POD_CD)" ).append("\n"); 
		query.append("#if(${vvd1}!='')" ).append("\n"); 
		query.append("and nvl(N1ST_LANE_CD, 'X') = nvl(decode((select VSL_SVC_TP_CD" ).append("\n"); 
		query.append("from MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("where VSL_SLAN_CD =  @[lane1]), 'O', 'FDR'," ).append("\n"); 
		query.append("(SELECT VSL_SLAN_CD LANE1" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD     = SUBSTR(@[vvd1], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd1], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd1], 9, 1)))," ).append("\n"); 
		query.append("nvl(N1ST_LANE_CD, 'X'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and nvl(N2ND_POL_CD , 'X') = nvl(@[pol2] , 'X')" ).append("\n"); 
		query.append("and nvl(N2ND_POD_CD , 'X') = nvl(@[pod2] , 'X')" ).append("\n"); 
		query.append("#if(${vvd2}!='')" ).append("\n"); 
		query.append("and nvl(N2ND_LANE_CD, 'X') = nvl(decode((select VSL_SVC_TP_CD" ).append("\n"); 
		query.append("from MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("where VSL_SLAN_CD =  @[lane2]), 'O', 'FDR'," ).append("\n"); 
		query.append("(SELECT VSL_SLAN_CD LANE2" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD     = SUBSTR(@[vvd2], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd2], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd2], 9, 1)))," ).append("\n"); 
		query.append("nvl(N2ND_LANE_CD, 'X'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and nvl(N3RD_POL_CD , 'X') = nvl(@[pol3] , 'X')" ).append("\n"); 
		query.append("and nvl(N3RD_POD_CD , 'X') = nvl(@[pod3] , 'X')" ).append("\n"); 
		query.append("#if(${vvd3}!='')" ).append("\n"); 
		query.append("and nvl(N3RD_LANE_CD, 'X') = nvl(decode((select VSL_SVC_TP_CD" ).append("\n"); 
		query.append("from MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("where VSL_SLAN_CD = @[lane3]), 'O', 'FDR'," ).append("\n"); 
		query.append("(SELECT VSL_SLAN_CD LANE3" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD     = SUBSTR(@[vvd3], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd3], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd3], 9, 1)))," ).append("\n"); 
		query.append("nvl(N3RD_LANE_CD, 'X'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and nvl(N4TH_POL_CD , 'X') = nvl(@[pol4] , 'X')" ).append("\n"); 
		query.append("and nvl(N4TH_POD_CD , 'X') = nvl(@[pod4] , 'X')" ).append("\n"); 
		query.append("#if(${vvd4}!='')" ).append("\n"); 
		query.append("and nvl(N4TH_LANE_CD, 'X') = nvl(decode((select VSL_SVC_TP_CD" ).append("\n"); 
		query.append("from MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("where VSL_SLAN_CD = @[lane4]), 'O', 'FDR'," ).append("\n"); 
		query.append("(SELECT VSL_SLAN_CD LANE4" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE VSL_CD     = SUBSTR(@[vvd4], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd4], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd4], 9, 1)))," ).append("\n"); 
		query.append("nvl(N4TH_LANE_CD, 'X'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") route," ).append("\n"); 
		query.append("#if(${bkg_no}!='')" ).append("\n"); 
		query.append("(select count(1) cop_count" ).append("\n"); 
		query.append("from sce_cop_hdr" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]) cop_count" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("0 cop_count" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}