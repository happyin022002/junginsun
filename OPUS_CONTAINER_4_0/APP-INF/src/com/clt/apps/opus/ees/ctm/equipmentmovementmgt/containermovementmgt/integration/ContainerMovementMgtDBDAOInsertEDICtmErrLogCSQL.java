/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOInsertEDICtmErrLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOInsertEDICtmErrLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertEDICtmErrLog
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOInsertEDICtmErrLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dat_mnpl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOInsertEDICtmErrLogCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_OSCA_BKG_BRG_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BRG_TP_ID 		 ," ).append("\n"); 
		query.append("    OSCA_BRG_YRMONDY ," ).append("\n"); 
		query.append("    OSCA_BRG_SEQ     ," ).append("\n"); 
		query.append("    BKG_NO           ," ).append("\n"); 
		query.append("    BL_NO            ," ).append("\n"); 
		query.append("    CNTR_NO          ," ).append("\n"); 
		query.append("    VSL_CD           ," ).append("\n"); 
		query.append("    SKD_VOY_NO       ," ).append("\n"); 
		query.append("    SKD_DIR_CD       ," ).append("\n"); 
		query.append("    ERR_MSG          ," ).append("\n"); 
		query.append("    CRE_USR_ID       ," ).append("\n"); 
		query.append("    CRE_DT           ," ).append("\n"); 
		query.append("    UPD_USR_ID       ," ).append("\n"); 
		query.append("    UPD_DT           ," ).append("\n"); 
		query.append("    DAT_MNPL_CD      " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[brg_tp_id] 		," ).append("\n"); 
		query.append("    to_char(sysdate, 'yymmdd') ," ).append("\n"); 
		query.append("    nvl((select max(OSCA_BRG_SEQ)+1 from CTM_OSCA_BKG_BRG_HIS where BRG_TP_ID=@[brg_tp_id] and OSCA_BRG_YRMONDY=to_char(sysdate, 'yymmdd')), 1)    ," ).append("\n"); 
		query.append("    @[bkg_no]           ," ).append("\n"); 
		query.append("    @[bl_no]            ," ).append("\n"); 
		query.append("    @[cntr_no]          ," ).append("\n"); 
		query.append("    @[vsl_cd]           ," ).append("\n"); 
		query.append("    @[skd_voy_no]       ," ).append("\n"); 
		query.append("    @[skd_dir_cd]       ," ).append("\n"); 
		query.append("    @[err_msg]          ," ).append("\n"); 
		query.append("    'BRIDGE'       		," ).append("\n"); 
		query.append("    sysdate           	," ).append("\n"); 
		query.append("    'BRIDGE'       		," ).append("\n"); 
		query.append("    sysdate           	," ).append("\n"); 
		query.append("    @[dat_mnpl_cd]      " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}