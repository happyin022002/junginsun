/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommodityDBDAOAddCustPackageTypeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.03.07 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.commodity.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Cho In Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAOAddCustPackageTypeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03.07 조인영 Cust Package Type 정보를 생성한다.
	  * </pre>
	  */
	public CommodityDBDAOAddCustPackageTypeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.commodity.integration ").append("\n"); 
		query.append("FileName : CommodityDBDAOAddCustPackageTypeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CSTMS_PCK_TP (" ).append("\n"); 
		query.append("       PCK_CD" ).append("\n"); 
		query.append("      ,CSTMS_CNT_CD" ).append("\n"); 
		query.append("      ,PCK_CSTMS_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	    @[pck_cd]" ).append("\n"); 
		query.append("       ,@[cstms_cnt_cd]" ).append("\n"); 
		query.append("       ,@[pck_cstms_cd]" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[delt_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}