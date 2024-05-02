/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAOPriSqScgAdjVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.11.12 송민석
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

public class SCRateQuotationDBDAOPriSqScgAdjVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *       CM/OP 산출 이후 Conversion 대상이 되는 예외적용 Surcharge 값을 반영하여 Simulation하기 위한 정보 delete
	  * </pre>
	  */
	public SCRateQuotationDBDAOPriSqScgAdjVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : SCRateQuotationDBDAOPriSqScgAdjVODSQL").append("\n"); 
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
		query.append("DELETE FROM pri_sq_scg_adj" ).append("\n"); 
		query.append("WHERE qttn_no = @[qttn_no]" ).append("\n"); 
		query.append("and qttn_ver_no = @[qttn_ver_no]" ).append("\n"); 
		query.append("and scg_adj_seq = @[scg_adj_seq]" ).append("\n"); 
		query.append("and gen_spcl_rt_tp_cd=@[gen_spcl_rt_tp_cd]" ).append("\n"); 

	}
}