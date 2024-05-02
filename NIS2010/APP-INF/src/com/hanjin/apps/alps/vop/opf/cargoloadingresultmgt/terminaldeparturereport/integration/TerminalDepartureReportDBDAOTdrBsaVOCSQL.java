/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrBsaVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.20 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrBsaVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * Ticket ID : CHM-201007765-01
	  * 개발자 : 박희동(2010-12-20)
	  * 수정내용 : UPD_SYS_CD 컬럼추가...N으로 setting
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrBsaVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty_45",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc40_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc40_rat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_rat_45",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc20_rat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc20_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ov_rat_45",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrBsaVOCSQL").append("\n"); 
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
		query.append("INSERT INTO TDR_BSA(" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	VOY_NO          " ).append("\n"); 
		query.append(",	DIR_CD          " ).append("\n"); 
		query.append(",	PORT_CD         " ).append("\n"); 
		query.append(",	CALL_IND        " ).append("\n"); 
		query.append(",	OPR_CD          " ).append("\n"); 
		query.append(",	TTL_QTY         " ).append("\n"); 
		query.append(",	TTL_WGT         " ).append("\n"); 
		query.append(",	HC40_QTY        " ).append("\n"); 
		query.append(",	HC40_RAT        " ).append("\n"); 
		query.append(",	HC20_QTY        " ).append("\n"); 
		query.append(",	HC20_RAT        " ).append("\n"); 
		query.append(",	QTY_45          " ).append("\n"); 
		query.append(",	UN_RAT_45       " ).append("\n"); 
		query.append(",	OV_RAT_45       " ).append("\n"); 
		query.append(",	TTL_RAT         " ).append("\n"); 
		query.append(",	UPDATE_USER     " ).append("\n"); 
		query.append(",	UPDATE_TIME     " ).append("\n"); 
		query.append(",	TEU_WGT" ).append("\n"); 
		query.append(",   UPD_SYS_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[voy_no]          " ).append("\n"); 
		query.append(",	@[dir_cd]          " ).append("\n"); 
		query.append(",	@[port_cd]         " ).append("\n"); 
		query.append(",	@[call_ind]        " ).append("\n"); 
		query.append(",	@[opr_cd]          " ).append("\n"); 
		query.append(",	@[ttl_qty]         " ).append("\n"); 
		query.append(",	@[ttl_wgt]         " ).append("\n"); 
		query.append(",	@[hc40_qty]        " ).append("\n"); 
		query.append(",	@[hc40_rat]        " ).append("\n"); 
		query.append(",	@[hc20_qty]        " ).append("\n"); 
		query.append(",	@[hc20_rat]        " ).append("\n"); 
		query.append(",	@[qty_45]          " ).append("\n"); 
		query.append(",	@[un_rat_45]       " ).append("\n"); 
		query.append(",	@[ov_rat_45]       " ).append("\n"); 
		query.append(",	@[ttl_rat]         " ).append("\n"); 
		query.append(",	@[update_user]     " ).append("\n"); 
		query.append(",	@[update_time]     " ).append("\n"); 
		query.append(",	@[teu_wgt]" ).append("\n"); 
		query.append(",   'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}