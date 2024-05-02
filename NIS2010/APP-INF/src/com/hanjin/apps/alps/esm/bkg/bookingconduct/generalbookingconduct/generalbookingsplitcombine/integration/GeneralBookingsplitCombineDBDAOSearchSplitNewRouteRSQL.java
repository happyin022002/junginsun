/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingsplitCombineDBDAOSearchSplitNewRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.26 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingsplitCombineDBDAOSearchSplitNewRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * split시 변경된 route의 정보를 조회한다
	  * </pre>
	  */
	public GeneralBookingsplitCombineDBDAOSearchSplitNewRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingsplitCombineDBDAOSearchSplitNewRouteRSQL").append("\n"); 
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
		query.append("select BKG_JOIN_FNC(CURSOR(select substr(ORG_NOD_CD,  1, 5)     ||'|'||" ).append("\n"); 
		query.append("ORG_NOD_CD                    ||'|'||" ).append("\n"); 
		query.append("substr(DEST_NOD_CD, 1, 5)     ||'|'||" ).append("\n"); 
		query.append("DEST_NOD_CD                   ||'|'||" ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD||'|'||" ).append("\n"); 
		query.append("VSL_SLAN_CD                   ||'|'||" ).append("\n"); 
		query.append("ORG_CLPT_IND_SEQ              ||'|'||" ).append("\n"); 
		query.append("DEST_CLPT_IND_SEQ             ||'|'" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("where pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and substr(ORG_NOD_CD, 1, 5) <> substr(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("and PCTL_IO_BND_CD = 'T')) rtn_route" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}