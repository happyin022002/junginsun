/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOExeSaveAsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.05 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOExeSaveAsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOExeSaveAsCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_port_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_imdg_port_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO SCG_IMDG_PORT_RSTR" ).append("\n"); 
		query.append("( PORT_CD                        ," ).append("\n"); 
		query.append("IMDG_PORT_RSTR_SEQ             ," ).append("\n"); 
		query.append("IMDG_PORT_RSTR_EXPT_FLG        ," ).append("\n"); 
		query.append("IMDG_UN_NO                     ," ).append("\n"); 
		query.append("IMDG_UN_NO_SEQ                 ," ).append("\n"); 
		query.append("IMDG_CLSS_CD                   ," ).append("\n"); 
		query.append("PROHI_LOD_FLG                  ," ).append("\n"); 
		query.append("PROHI_DCHG_FLG                 ," ).append("\n"); 
		query.append("PROHI_TS_FLG                   ," ).append("\n"); 
		query.append("PROHI_PASS_FLG                 ," ).append("\n"); 
		query.append("PROHI_DY_TM_OP_FLG             ," ).append("\n"); 
		query.append("PROHI_DY_TM_INLND_TZ_FLG       ," ).append("\n"); 
		query.append("PROHI_PORT_FLG                 ," ).append("\n"); 
		query.append("PROHI_PINSP_FLG                ," ).append("\n"); 
		query.append("XTRA_HNDL_CHG_FLG              ," ).append("\n"); 
		query.append("SFT_GAD_FLG                    ," ).append("\n"); 
		query.append("KEP_SFT_DIST_IHB_FLG           ," ).append("\n"); 
		query.append("KEP_SFT_DIST_IHB_DIST          ," ).append("\n"); 
		query.append("RSTR_RMK                       ," ).append("\n"); 
		query.append("PROHI_NGT_FLG                  ," ).append("\n"); 
		query.append("DIR_LOD_FLG                    ," ).append("\n"); 
		query.append("DIR_DCHG_FLG                   ," ).append("\n"); 
		query.append("DIR_TS_FLG                     ," ).append("\n"); 
		query.append("CRE_USR_ID                     ," ).append("\n"); 
		query.append("UPD_USR_ID                     ," ).append("\n"); 
		query.append("CRE_DT                         ," ).append("\n"); 
		query.append("UPD_DT                         )" ).append("\n"); 
		query.append("SELECT  @[new_port_cd] PORT_CD             ," ).append("\n"); 
		query.append("@[new_imdg_port_rstr_seq]  IMDG_PORT_RSTR_SEQ  ," ).append("\n"); 
		query.append("IMDG_PORT_RSTR_EXPT_FLG        ," ).append("\n"); 
		query.append("#if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("@[imdg_un_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IMDG_UN_NO        ," ).append("\n"); 
		query.append("#if (${imdg_un_no_seq} != '' )" ).append("\n"); 
		query.append("@[imdg_un_no_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IMDG_UN_NO_SEQ ," ).append("\n"); 
		query.append("@[imdg_clss_cd] IMDG_CLSS_CD   ," ).append("\n"); 
		query.append("PROHI_LOD_FLG                  ," ).append("\n"); 
		query.append("PROHI_DCHG_FLG                 ," ).append("\n"); 
		query.append("PROHI_TS_FLG                   ," ).append("\n"); 
		query.append("PROHI_PASS_FLG                 ," ).append("\n"); 
		query.append("PROHI_DY_TM_OP_FLG             ," ).append("\n"); 
		query.append("PROHI_DY_TM_INLND_TZ_FLG       ," ).append("\n"); 
		query.append("PROHI_PORT_FLG                 ," ).append("\n"); 
		query.append("PROHI_PINSP_FLG                ," ).append("\n"); 
		query.append("XTRA_HNDL_CHG_FLG              ," ).append("\n"); 
		query.append("SFT_GAD_FLG                    ," ).append("\n"); 
		query.append("KEP_SFT_DIST_IHB_FLG           ," ).append("\n"); 
		query.append("KEP_SFT_DIST_IHB_DIST          ," ).append("\n"); 
		query.append("RSTR_RMK                       ," ).append("\n"); 
		query.append("PROHI_NGT_FLG                  ," ).append("\n"); 
		query.append("DIR_LOD_FLG                    ," ).append("\n"); 
		query.append("DIR_DCHG_FLG                   ," ).append("\n"); 
		query.append("DIR_TS_FLG                     ," ).append("\n"); 
		query.append("@[cre_usr_id]                  ," ).append("\n"); 
		query.append("@[cre_usr_id]                   ," ).append("\n"); 
		query.append("SYSDATE                         ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM SCG_IMDG_PORT_RSTR" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port_cd] AND  IMDG_PORT_RSTR_SEQ= @[imdg_port_rstr_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOExeSaveAsCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}