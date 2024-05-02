/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOremoveRFsparePartCodeDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.18 이용태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOremoveRFsparePartCodeDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOremoveRFsparePartCodeDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_spl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOremoveRFsparePartCodeDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_RF_SPR_PRT_CD " ).append("\n"); 
		query.append("WHERE SPR_PRT_NO = @[spr_prt_no]" ).append("\n"); 
		query.append("AND   SPR_PRT_SPL_TP_CD = @[spr_prt_spl_tp_cd]" ).append("\n"); 

	}
}