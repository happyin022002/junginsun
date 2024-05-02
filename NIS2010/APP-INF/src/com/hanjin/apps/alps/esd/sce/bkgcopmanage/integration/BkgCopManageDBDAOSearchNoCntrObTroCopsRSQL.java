/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchNoCntrObTroCopsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchNoCntrObTroCopsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container 가 assign 되지 않았으며 O/B Tro 가 mapping 된 COP 를 찾는다. (찾아진 COP 는 Container 가 존재하는 ob tro 가
	  * 연결안된 cop 로 해당 정보가 이동될 대상이 된다.)
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchNoCntrObTroCopsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchNoCntrObTroCopsRSQL").append("\n"); 
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
		query.append("select cop_no," ).append("\n"); 
		query.append("  bkg_no," ).append("\n"); 
		query.append("  ob_tro_flg," ).append("\n"); 
		query.append("  TO_CHAR(CFM_OB_DOR_ARR_DT, 'YYYYMMDDHH24MI') AS CFM_OB_DOR_ARR_DT" ).append("\n"); 
		query.append("from sce_cop_hdr a" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("  and cntr_no = 'SMCU0000000'" ).append("\n"); 
		query.append("  and cop_sts_cd != 'X'" ).append("\n"); 
		query.append("  and ob_tro_flg = 'Y'" ).append("\n"); 

	}
}