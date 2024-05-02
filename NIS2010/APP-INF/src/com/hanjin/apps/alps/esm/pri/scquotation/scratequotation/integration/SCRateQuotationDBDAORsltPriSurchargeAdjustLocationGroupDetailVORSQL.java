/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAORsltPriSurchargeAdjustLocationGroupDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.03 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAORsltPriSurchargeAdjustLocationGroupDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *       Surcharge Adjust Location 상세 조회
	  * </pre>
	  */
	public SCRateQuotationDBDAORsltPriSurchargeAdjustLocationGroupDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAORsltPriSurchargeAdjustLocationGroupDetailVORSQL").append("\n"); 
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
		query.append("SELECT loc_cd,loc_nm" ).append("\n"); 
		query.append(",qttn_no,qttn_ver_no,grp_loc_seq" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT loc_mdm.loc_cd,loc_mdm.loc_nm" ).append("\n"); 
		query.append(",loc_dtl.qttn_no,loc_dtl.qttn_ver_no,loc_dtl.grp_loc_seq" ).append("\n"); 
		query.append("FROM pri_sq_grp_loc_dtl loc_dtl" ).append("\n"); 
		query.append(", mdm_location loc_mdm" ).append("\n"); 
		query.append("WHERE loc_dtl.qttn_no = @[qttn_no]" ).append("\n"); 
		query.append("AND loc_dtl.qttn_ver_no = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND loc_dtl.grp_loc_seq = @[grp_loc_seq]" ).append("\n"); 
		query.append("AND loc_dtl.loc_cd = loc_mdm.loc_cd" ).append("\n"); 
		query.append("AND 'G' = @[rout_loc_tp_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT loc_mdm.loc_cd , loc_mdm.loc_nm" ).append("\n"); 
		query.append(",'' ,'',0 AS grp_loc_seq" ).append("\n"); 
		query.append("FROM mdm_location loc_mdm" ).append("\n"); 
		query.append("WHERE 	loc_mdm.loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("AND 'L' = @[rout_loc_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY loc_cd" ).append("\n"); 

	}
}