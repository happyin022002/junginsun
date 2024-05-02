/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RegionDepartureReportDBDAOAddRdrRfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOAddRdrRfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR RF 자료를 생성한다.
	  * </pre>
	  */
	public RegionDepartureReportDBDAOAddRdrRfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("weight",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slot_add",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_size",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOAddRdrRfCSQL").append("\n"); 
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
		query.append("INSERT INTO  RDR_SUMMARY (VSL_CD" ).append("\n"); 
		query.append(",                         VOY_NO" ).append("\n"); 
		query.append(",                         DIR_CD" ).append("\n"); 
		query.append(",                         REGION" ).append("\n"); 
		query.append(",                         STATUS" ).append("\n"); 
		query.append(",                         OPR_CD" ).append("\n"); 
		query.append(",                         POL" ).append("\n"); 
		query.append(",                         POD" ).append("\n"); 
		query.append(",                         CNTR_TYPE" ).append("\n"); 
		query.append(",                         CNTR_SIZE" ).append("\n"); 
		query.append(",                         QTY" ).append("\n"); 
		query.append(",                         SLOT_ADD" ).append("\n"); 
		query.append(",                         POD_ISO" ).append("\n"); 
		query.append(",                         WEIGHT" ).append("\n"); 
		query.append(",                         UPDATE_USER" ).append("\n"); 
		query.append(",                         UPDATE_TIME" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(@[vsl_cd]     " ).append("\n"); 
		query.append(",      @[voy_no]     " ).append("\n"); 
		query.append(",      @[dir_cd]     " ).append("\n"); 
		query.append(",      @[region]     " ).append("\n"); 
		query.append(",      'RS'     " ).append("\n"); 
		query.append(",      @[opr_cd]     " ).append("\n"); 
		query.append(",      @[pol]        " ).append("\n"); 
		query.append(",      @[pod]        " ).append("\n"); 
		query.append(",      @[cntr_type]  " ).append("\n"); 
		query.append(",      @[cntr_size]  " ).append("\n"); 
		query.append(",      @[qty]        " ).append("\n"); 
		query.append(",      @[slot_add]   " ).append("\n"); 
		query.append(",      @[pod]    " ).append("\n"); 
		query.append(",      @[weight]     " ).append("\n"); 
		query.append(",      @[update_user]" ).append("\n"); 
		query.append(",      SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}