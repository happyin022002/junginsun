/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PrdCommonManageDBDAOCreatePrdNodeByYardCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOCreatePrdNodeByYardCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CCD Yard Creation시 PRD Node도 생성한다.
	  * </pre>
	  */
	public PrdCommonManageDBDAOCreatePrdNodeByYardCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOCreatePrdNodeByYardCSQL").append("\n"); 
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
		query.append("INSERT INTO prd_node (                                      		" ).append("\n"); 
		query.append("				nod_cd 	       ,nod_nm 	       ,nod_tp_cd      ,loc_cd 	       ," ).append("\n"); 
		query.append("				onf_hir_yd_flg ,delt_flg       ,cre_usr_id     ,cre_dt 	       ," ).append("\n"); 
		query.append("				upd_usr_id     ,upd_dt )                                                           		" ).append("\n"); 
		query.append("VALUES  (		@[yd_cd] ,@[yd_nm] ," ).append("\n"); 
		query.append("				#if(${yd_fcty_tp_psdo_yd_flg} =='Y')" ).append("\n"); 
		query.append("					'Y'" ).append("\n"); 
		query.append("				#elseif(${yd_fcty_tp_mrn_tml_flg} =='Y')" ).append("\n"); 
		query.append("					'M'" ).append("\n"); 
		query.append("				#elseif(${yd_fcty_tp_brg_rmp_flg} =='Y')" ).append("\n"); 
		query.append("					'B'" ).append("\n"); 
		query.append("				#elseif(${yd_fcty_tp_rail_rmp_flg} =='Y')" ).append("\n"); 
		query.append("					'R'" ).append("\n"); 
		query.append("				#elseif(${yd_fcty_tp_cy_flg} =='Y')" ).append("\n"); 
		query.append("					'Y'" ).append("\n"); 
		query.append("				#elseif(${yd_fcty_tp_cfs_flg} =='Y')" ).append("\n"); 
		query.append("					'S'" ).append("\n"); 
		query.append("				#elseif(${yd_fcty_tp_psdo_yd_flg} !='Y' &&" ).append("\n"); 
		query.append("						${yd_fcty_tp_mrn_tml_flg} !='Y' &&" ).append("\n"); 
		query.append("						${yd_fcty_tp_brg_rmp_flg} !='Y' &&" ).append("\n"); 
		query.append("						${yd_fcty_tp_rail_rmp_flg} !='Y' &&" ).append("\n"); 
		query.append("						${yd_fcty_tp_cy_flg} !='Y' &&" ).append("\n"); 
		query.append("						${yd_fcty_tp_cfs_flg} !='Y' )" ).append("\n"); 
		query.append("					'Y'" ).append("\n"); 
		query.append("				#end," ).append("\n"); 
		query.append("				SUBSTR(@[yd_cd],1,5) ,												 		" ).append("\n"); 
		query.append("				'N' ,@[delt_flg] ,@[usr_id] ,sysdate," ).append("\n"); 
		query.append("				@[usr_id] ,sysdate" ).append("\n"); 
		query.append("			 )" ).append("\n"); 

	}
}