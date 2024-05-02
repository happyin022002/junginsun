/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchLoadingPortRsoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.16 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOSearchLoadingPortRsoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchLoadingPortRsoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("a.loc_cd key_loc_cd, a.rgn_shp_opr_cd key_rgn_shp_opr_cd," ).append("\n"); 
		query.append("a.loc_cd, a.rgn_shp_opr_cd, b.loc_nm," ).append("\n"); 
		query.append("a.delt_flg,a.cre_usr_id,a.cre_dt,a.upd_usr_id,a.upd_dt," ).append("\n"); 
		query.append("(select d.cnt_nm from mdm_country d where d.cnt_cd=b.cnt_cd)cnt_nm" ).append("\n"); 
		query.append("FROM   scg_rgn_shp_opr_port a," ).append("\n"); 
		query.append("mdm_location b" ).append("\n"); 
		query.append("WHERE   a.loc_cd = b.loc_cd" ).append("\n"); 
		query.append("AND   a.delt_flg ='N'" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("AND   a.rgn_shp_opr_cd      = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by a.loc_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchLoadingPortRsoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}