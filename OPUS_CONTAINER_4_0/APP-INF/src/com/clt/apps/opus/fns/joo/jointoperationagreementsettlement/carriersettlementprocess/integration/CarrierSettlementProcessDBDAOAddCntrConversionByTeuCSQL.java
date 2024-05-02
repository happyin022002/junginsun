/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOAddCntrConversionByTeuCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOAddCntrConversionByTeuCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TEU Insert
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOAddCntrConversionByTeuCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_normal_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_cnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOAddCntrConversionByTeuCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO JOO_COM_PPT ( " ).append("\n"); 
		query.append("       PPT_CD " ).append("\n"); 
		query.append("     , LINE_SEQ " ).append("\n"); 
		query.append("     , ATTR_CTNT1 " ).append("\n"); 
		query.append("     , ATTR_CTNT2 " ).append("\n"); 
		query.append("     , ATTR_CTNT3 " ).append("\n"); 
		query.append("     , ATTR_CTNT4 " ).append("\n"); 
		query.append("     , ATTR_CTNT5 " ).append("\n"); 
		query.append("     , ATTR_CTNT6 " ).append("\n"); 
		query.append("     , ATTR_CTNT7 " ).append("\n"); 
		query.append("     , ATTR_CTNT8 " ).append("\n"); 
		query.append("     , ATTR_CTNT9 " ).append("\n"); 
		query.append("     , ATTR_CTNT10 " ).append("\n"); 
		query.append("     , CRE_USR_ID " ).append("\n"); 
		query.append("     , CRE_DT " ).append("\n"); 
		query.append("     , UPD_USR_ID " ).append("\n"); 
		query.append("     , UPD_DT )" ).append("\n"); 
		query.append("VALUES ( " ).append("\n"); 
		query.append("       @[ppt_cd]" ).append("\n"); 
		query.append("     , @[line_seq]" ).append("\n"); 
		query.append("     , @[slan_cd] --ATTR_CTNT1" ).append("\n"); 
		query.append("     , @[tgt_normal_tpsz] --ATTR_CTNT2" ).append("\n"); 
		query.append("     , @[teu_cnt] --ATTR_CTNT3" ).append("\n"); 
		query.append("     , NULL --ATTR_CTNT4" ).append("\n"); 
		query.append("     , NULL --ATTR_CTNT5" ).append("\n"); 
		query.append("     , NULL --ATTR_CTNT6" ).append("\n"); 
		query.append("     , NULL --ATTR_CTNT7" ).append("\n"); 
		query.append("     , NULL --ATTR_CTNT8" ).append("\n"); 
		query.append("     , NULL --ATTR_CTNT9" ).append("\n"); 
		query.append("     , NULL --ATTR_CTNT10" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE )" ).append("\n"); 

	}
}