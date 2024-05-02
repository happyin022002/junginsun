/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckVslSkdByRowID2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCheckVslSkdByRowID2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckVslSkdByRowID2
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckVslSkdByRowID2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckVslSkdByRowID2RSQL").append("\n"); 
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
		query.append("SELECT		V.VSL_CD" ).append("\n"); 
		query.append("		,	V.SKD_VOY_NO" ).append("\n"); 
		query.append("		,	V.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	V.POD_CD			AS VPS_PORT_CD" ).append("\n"); 
		query.append("		,	V.POD_YD_CD			AS YD_CD" ).append("\n"); 
		query.append("		,	'VIRTUAL'			AS BKG_VVD_KND" ).append("\n"); 
		query.append("FROM      	BKG_VVD       		V" ).append("\n"); 
		query.append("WHERE     	V.VSL_CD      		= @[vsl_cd]" ).append("\n"); 
		query.append("AND       	V.SKD_VOY_NO  		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND       	V.SKD_DIR_CD  		= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND       	V.POD_CD      		= @[vps_port_cd]" ).append("\n"); 
		query.append("AND       	V.POD_CLPT_IND_SEQ  = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND			ROWNUM				= 1" ).append("\n"); 

	}
}