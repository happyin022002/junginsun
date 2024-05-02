/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOCheckVskActPortSkdChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.02.28 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOCheckVskActPortSkdChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD/Port에 대해서 Booking 정보가 생성되여 있는 확인하여 Actual Port Schedule History 정보를 남겨야 하는지 여부를 판단한다.
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOCheckVskActPortSkdChangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_port_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOCheckVskActPortSkdChangeRSQL").append("\n"); 
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
		query.append("SELECT	DECODE(NVL(@[act_arr_dt]	, ' ')	, NVL(T22.ATA	, ' '), 0, 1) AS ATA_CHK" ).append("\n"); 
		query.append("        , DECODE(NVL(@[act_brth_dt]		, ' ')	, NVL(T22.ATB	, ' '), 0, 1) AS ATB_CHK" ).append("\n"); 
		query.append("        , DECODE(NVL(@[act_dep_dt]		, ' ')	, NVL(T22.ATD	, ' '), 0, 1) AS ATD_CHK" ).append("\n"); 
		query.append("        , DECODE(NVL(@[upd_usr_id]		, ' ')	, NVL(T22.USR_ID	, ' '), 0, 1) AS USR_CHK" ).append("\n"); 
		query.append("        , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), NVL(T22.ACT_ATA_INP_DT, SYSDATE), NVL(T22.VPS_PORT_CD, @[vps_port_cd])), 'YYYYMMDDHH24MI') AS ATA_LOC_TIME" ).append("\n"); 
		query.append("        , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), NVL(T22.ACT_ATB_INP_DT, SYSDATE), NVL(T22.VPS_PORT_CD, @[vps_port_cd])), 'YYYYMMDDHH24MI') AS ATB_LOC_TIME" ).append("\n"); 
		query.append("        , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), NVL(T22.ACT_ATD_INP_DT, SYSDATE), NVL(T22.VPS_PORT_CD, @[vps_port_cd])), 'YYYYMMDDHH24MI') AS ATD_LOC_TIME" ).append("\n"); 
		query.append("        , (DECODE(NVL(@[act_arr_dt]	, ' ')	, NVL(T22.ATA	, ' '), 0, 1)" ).append("\n"); 
		query.append("          + DECODE(NVL(@[act_brth_dt]		, ' ')	, NVL(T22.ATB	, ' '), 0, 1)" ).append("\n"); 
		query.append("          + DECODE(NVL(@[act_dep_dt]		, ' ')	, NVL(T22.ATD	, ' '), 0, 1)" ).append("\n"); 
		query.append("          + DECODE(NVL(@[upd_usr_id]		, ' ')	, NVL(T22.USR_ID	, ' '), 0, 1)) AS ALL_CHK" ).append("\n"); 
		query.append("		, CASE WHEN(" ).append("\n"); 
		query.append("					SELECT  'Y'" ).append("\n"); 
		query.append("					FROM	DUAL" ).append("\n"); 
		query.append("					WHERE 	1 = 1   " ).append("\n"); 
		query.append("					AND		(EXISTS (  SELECT  'X'" ).append("\n"); 
		query.append("                    					FROM    BKG_VVD S" ).append("\n"); 
		query.append("                    					WHERE   1 = 1" ).append("\n"); 
		query.append("                    					AND     S.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                    					AND     S.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                    					AND     S.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    					AND     (" ).append("\n"); 
		query.append("													(S.POL_CD      = @[vps_port_cd] AND S.POL_CLPT_IND_SEQ = @[clpt_ind_seq])" ).append("\n"); 
		query.append("													OR" ).append("\n"); 
		query.append("													(S.POD_CD      = @[vps_port_cd] AND S.POD_CLPT_IND_SEQ = @[clpt_ind_seq])" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("                					)" ).append("\n"); 
		query.append("         				)" ).append("\n"); 
		query.append("		  			) IS NULL" ).append("\n"); 
		query.append("				THEN 'X'" ).append("\n"); 
		query.append("				ELSE 'Y'" ).append("\n"); 
		query.append("				END AS BKG_CHK" ).append("\n"); 
		query.append("		, CASE WHEN(" ).append("\n"); 
		query.append("					SELECT  'Y'" ).append("\n"); 
		query.append("					FROM	DUAL" ).append("\n"); 
		query.append("					WHERE 	1 = 1   " ).append("\n"); 
		query.append("					AND		(EXISTS (  SELECT  'X'" ).append("\n"); 
		query.append("                    					FROM    BKG_VVD S" ).append("\n"); 
		query.append("                    					WHERE   1 = 1" ).append("\n"); 
		query.append("                    					AND     S.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                    					AND     S.SKD_VOY_NO       = DECODE(@[turn_port_flg], 'Y', @[turn_skd_voy_no], 'X')" ).append("\n"); 
		query.append("                    					AND     S.SKD_DIR_CD       = DECODE(@[turn_port_flg], 'Y', @[turn_skd_dir_cd], 'X')" ).append("\n"); 
		query.append("                    					AND     (" ).append("\n"); 
		query.append("													(S.POL_CD      = @[vps_port_cd] AND S.POL_CLPT_IND_SEQ = DECODE(@[turn_port_flg], 'Y', @[turn_clpt_ind_seq], 'X'))" ).append("\n"); 
		query.append("													OR" ).append("\n"); 
		query.append("													(S.POD_CD      = @[vps_port_cd] AND S.POD_CLPT_IND_SEQ = DECODE(@[turn_port_flg], 'Y', @[turn_clpt_ind_seq], 'X'))" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("                					)" ).append("\n"); 
		query.append("         				)" ).append("\n"); 
		query.append("		  			) IS NULL" ).append("\n"); 
		query.append("				THEN 'X'" ).append("\n"); 
		query.append("				ELSE 'Y'" ).append("\n"); 
		query.append("				END AS BKG_VRT_CHK" ).append("\n"); 
		query.append("FROM	DUAL T11, " ).append("\n"); 
		query.append("	(SELECT	'X'	AS XX" ).append("\n"); 
		query.append("		, TO_CHAR(ACT_ARR_DT	, 'YYYY-MM-DD HH24:MI')	AS ATA" ).append("\n"); 
		query.append("		, TO_CHAR(ACT_BRTH_DT	, 'YYYY-MM-DD HH24:MI')	AS ATB" ).append("\n"); 
		query.append("		, TO_CHAR(ACT_DEP_DT	, 'YYYY-MM-DD HH24:MI')	AS ATD" ).append("\n"); 
		query.append("		, ACT_ATA_INP_DT" ).append("\n"); 
		query.append("		, ACT_ATB_INP_DT" ).append("\n"); 
		query.append("		, ACT_ATD_INP_DT" ).append("\n"); 
		query.append("		, VPS_PORT_CD" ).append("\n"); 
		query.append("		, VSL_CD" ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, CLPT_IND_SEQ" ).append("\n"); 
		query.append("		, NVL(UPD_USR_ID, CRE_USR_ID) 			AS USR_ID" ).append("\n"); 
		query.append("	FROM	VSK_ACT_PORT_SKD T1" ).append("\n"); 
		query.append("	WHERE	VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("	AND	SKD_VOY_NO		= @[skd_voy_no]" ).append("\n"); 
		query.append("	AND	SKD_DIR_CD		= @[skd_dir_cd]" ).append("\n"); 
		query.append("	AND	VPS_PORT_CD		= @[vps_port_cd]" ).append("\n"); 
		query.append("	AND	CLPT_IND_SEQ	= @[clpt_ind_seq]" ).append("\n"); 
		query.append("	) T22" ).append("\n"); 
		query.append("WHERE	T11.DUMMY	= T22.XX	(+)" ).append("\n"); 

	}
}