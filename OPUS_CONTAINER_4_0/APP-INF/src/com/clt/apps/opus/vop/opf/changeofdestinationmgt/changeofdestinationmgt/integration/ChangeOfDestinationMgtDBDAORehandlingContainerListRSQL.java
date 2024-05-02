/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAORehandlingContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAORehandlingContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAORehandlingContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAORehandlingContainerListRSQL").append("\n"); 
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
		query.append("WITH MAX_CLPT_SEQ AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(V.CLPT_SEQ) 		CLPT_SEQ" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD 	V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD      		= SUBSTR( @[vvd], 1, 4 )    --:vsl_cd" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  		= SUBSTR( @[vvd], 5, 4 )    --:skd_voy_no" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  		= SUBSTR( @[vvd], 9, 1 )    --:skd_dir_cd" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD 		IN (SELECT 	DISTINCT B.PORT_CD" ).append("\n"); 
		query.append("                          		FROM   	VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("									,	BAY_PLAN B" ).append("\n"); 
		query.append("                          		WHERE  	1 = 1" ).append("\n"); 
		query.append("						  		AND	 	V.VPS_PORT_CD 	NOT IN ('EGSCA','PAPCA')" ).append("\n"); 
		query.append("						  		AND    	V.VSL_CD     	= SUBSTR( @[vvd], 1, 4 )    --:vsl_cd         " ).append("\n"); 
		query.append("                          		AND    	V.SKD_VOY_NO 	= SUBSTR( @[vvd], 5, 4 )    --:skd_voy_no" ).append("\n"); 
		query.append("                          		AND    	V.SKD_DIR_CD 	= SUBSTR( @[vvd], 9, 1 )    --:skd_dir_cd" ).append("\n"); 
		query.append("                          		AND    	V.CLPT_SEQ   	< ( SELECT CLPT_SEQ" ).append("\n"); 
		query.append("                                                   			FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                   			WHERE  VSL_CD     = SUBSTR( @[vvd], 1, 4 )    	--:vsl_cd    " ).append("\n"); 
		query.append("                                                   			AND    SKD_VOY_NO = SUBSTR( @[vvd], 5, 4 )    	--:skd_voy_no" ).append("\n"); 
		query.append("                                                   			AND    SKD_DIR_CD = SUBSTR( @[vvd], 9, 1 )    	--:skd_dir_cd" ).append("\n"); 
		query.append("                                                   			AND    YD_CD      = @[cod_rhnd_port_yd_cd]		--:cod_rhnd_port_yd_cd" ).append("\n"); 
		query.append("                                                   			AND    ROWNUM     = 1 )" ).append("\n"); 
		query.append("                          		AND    	V.VSL_CD     	= B.VSL_CD" ).append("\n"); 
		query.append("                          		AND    	DECODE(V.TURN_PORT_IND_CD,'D',V.TURN_SKD_VOY_NO,'V',V.TURN_SKD_VOY_NO,'F',V.TURN_SKD_VOY_NO,V.SKD_VOY_NO) = B.VOY_NO" ).append("\n"); 
		query.append("                          		AND    	DECODE(V.TURN_PORT_IND_CD,'D',V.TURN_SKD_DIR_CD,'V',V.TURN_SKD_DIR_CD,'F',V.TURN_SKD_DIR_CD,V.SKD_DIR_CD) = B.DIR_CD" ).append("\n"); 
		query.append("                          		AND    	V.VPS_PORT_CD 	= B.PORT_CD" ).append("\n"); 
		query.append("                          		AND    	B.PLAN_TYPE   	= 'F'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append(")                              " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT     	YY.TPSZ" ).append("\n"); 
		query.append("        ,  	YY.CNTR||' ('||YY.TPSZ||')'														AS CNTR" ).append("\n"); 
		query.append("        ,  	YY.FM" ).append("\n"); 
		query.append("        ,  	DECODE(YY.CATE,'DG','DG','RF','Reefer','AK','Awkward','BB','Break Bulk','Dry')	AS CGO_CATE_CD" ).append("\n"); 
		query.append("		,	YY.POL" ).append("\n"); 
		query.append("		,	YY.POD" ).append("\n"); 
		query.append("        ,  	YY.POL||'/'||YY.POD																AS PORT" ).append("\n"); 
		query.append("        ,  	YY.POSITION" ).append("\n"); 
		query.append("FROM   		( " ).append("\n"); 
		query.append("			--============================================================================================================================================" ).append("\n"); 
		query.append("      		-- In CASE Other BKG's POD except Self has Next Port of Rehandling One" ).append("\n"); 
		query.append("      		--============================================================================================================================================" ).append("\n"); 
		query.append("			SELECT   DISTINCT" ).append("\n"); 
		query.append("			         DECODE(Y.CNTR_TYPE,'N','D',Y.CNTR_TYPE)||DECODE(Y.CNTR_SIZE,'2','2','3','3','4','4','H','5','L','7')        						AS TPSZ" ).append("\n"); 
		query.append("			      ,  Y.ID                                                                                                        						AS CNTR" ).append("\n"); 
		query.append("			      ,  Y.FE                                                                                                        						AS FM" ).append("\n"); 
		query.append("			      ,  Y.PORT_CD                                                                                                   						AS PORT" ).append("\n"); 
		query.append("				  ,  Y.POL				AS POL" ).append("\n"); 
		query.append("				  ,	 Y.POD				AS POD" ).append("\n"); 
		query.append("			      ,  Y.BAY||Y.ROWW||Y.TIER                                                                                       						AS POSITION" ).append("\n"); 
		query.append("			      ,  DECODE(Y.CARGO_TYPE,'DG','DG',DECODE(Y.CARGO_TYPE,'RF','RF',DECODE(Y.CARGO_TYPE,'AK','AK',DECODE(Y.CARGO_TYPE,'BB','BB','DR'))))	AS CATE" ).append("\n"); 
		query.append("			      " ).append("\n"); 
		query.append("			      --,  '===================='" ).append("\n"); 
		query.append("			      --,  X.BAY,X.ROWW,X.TIER,X.SZTP_ISO,X.ID,X.POL,X.POL_ISO,X.POD,X.POD2,X.POD_ISO,X.POD2_ISO,   Y.BAY,Y.ROWW,Y.TIER,Y.SZTP_ISO,Y.ID,Y.POL,Y.POL_ISO,Y.POD,Y.POD2,Y.POD_ISO,Y.POD2_ISO" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			FROM     BAY_PLAN             X" ).append("\n"); 
		query.append("			      ,  BAY_PLAN             Y" ).append("\n"); 
		query.append("			      ,  VSK_VSL_PORT_SKD     XX" ).append("\n"); 
		query.append("			      ,  VSK_VSL_PORT_SKD     YY                   " ).append("\n"); 
		query.append("			WHERE    1 = 1" ).append("\n"); 
		query.append("			AND      X.VSL_CD             = XX.VSL_CD" ).append("\n"); 
		query.append("			AND      X.VOY_NO             = XX.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND      X.DIR_CD             = XX.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND      X.PORT_CD            = XX.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND      X.CALL_IND           = XX.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			AND      X.PLAN_TYPE          = 'F'" ).append("\n"); 
		query.append("			AND      Y.VSL_CD             = YY.VSL_CD" ).append("\n"); 
		query.append("			AND      Y.VOY_NO             = YY.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND      Y.DIR_CD             = YY.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND      Y.PORT_CD            = YY.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND      Y.CALL_IND           = YY.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			AND      Y.PLAN_TYPE          = 'F'" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND      X.VSL_CD             = Y.VSL_CD" ).append("\n"); 
		query.append("			AND      X.VOY_NO             = Y.VOY_NO" ).append("\n"); 
		query.append("			AND      X.DIR_CD             = Y.DIR_CD" ).append("\n"); 
		query.append("			AND      X.PORT_CD            = Y.PORT_CD" ).append("\n"); 
		query.append("			AND      X.CALL_IND           = Y.CALL_IND" ).append("\n"); 
		query.append("			AND      X.VSL_CD             = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("			AND      X.VOY_NO             = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("			AND      X.DIR_CD             = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("			AND      XX.CLPT_SEQ          = (SELECT CLPT_SEQ FROM MAX_CLPT_SEQ)" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			--AND      X.PORT_CD            = 'CNSHA'" ).append("\n"); 
		query.append("			--AND      X.CALL_IND           = '1'" ).append("\n"); 
		query.append("			                                   " ).append("\n"); 
		query.append("			#if (${cntr_no} != '') " ).append("\n"); 
		query.append("			AND      X.ID                 IN (		--'NYKU3839440','SEGU2062320'" ).append("\n"); 
		query.append("			#foreach($key IN ${cntr_no}) " ).append("\n"); 
		query.append("				#if($velocityCount < $cntr_no.size()) " ).append("\n"); 
		query.append("					'$key', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("											)  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND      1                    = CASE WHEN TRUNC(TO_NUMBER(X.BAY)/4) <> TRUNC(TO_NUMBER(Y.BAY)/4) THEN 0                                    -- << SAME BAY >> --" ).append("\n"); 
		query.append("			                                     ELSE                                   " ).append("\n"); 
		query.append("			                                          CASE WHEN MOD(TO_NUMBER(X.BAY),2) = 0 THEN 1                                                    -- << 40 FEET + 20/40 FEET  >> --" ).append("\n"); 
		query.append("			                                               WHEN MOD(TO_NUMBER(X.BAY),2) = 1 AND MOD(TO_NUMBER(Y.BAY),2) = 0 THEN 1                    -- << 20 FEET + 40    FEET >> --" ).append("\n"); 
		query.append("			                                               WHEN MOD(TO_NUMBER(X.BAY),2) = 1 AND MOD(TO_NUMBER(Y.BAY),2) = 1 AND X.BAY = Y.BAY THEN 1  -- << 20 FEET + 20    FEET >> -- " ).append("\n"); 
		query.append("			                                               ELSE 0" ).append("\n"); 
		query.append("			                                          END                        " ).append("\n"); 
		query.append("			                                END" ).append("\n"); 
		query.append("			                          " ).append("\n"); 
		query.append("			AND      1                    = CASE WHEN (SELECT  MAX(PS.CLPT_SEQ)" ).append("\n"); 
		query.append("			                                           FROM    VSK_VSL_PORT_SKD PS " ).append("\n"); 
		query.append("			                                           WHERE   PS.VSL_CD        = X.VSL_CD" ).append("\n"); 
		query.append("			                                           AND     PS.SKD_VOY_NO    = X.VOY_NO" ).append("\n"); 
		query.append("			                                           AND     PS.SKD_DIR_CD    = X.DIR_CD" ).append("\n"); 
		query.append("			                                           AND     PS.YD_CD         = @[cod_rhnd_port_yd_cd] 	-- [rehandling terminal] --" ).append("\n"); 
		query.append("			                                           ) <" ).append("\n"); 
		query.append("			                                          (SELECT  MAX(PS.CLPT_SEQ)" ).append("\n"); 
		query.append("			                                           FROM    VSK_VSL_PORT_SKD PS " ).append("\n"); 
		query.append("			                                           WHERE   PS.VSL_CD        = Y.VSL_CD" ).append("\n"); 
		query.append("			                                           AND     PS.SKD_VOY_NO    = Y.VOY_NO" ).append("\n"); 
		query.append("			                                           AND     PS.SKD_DIR_CD    = Y.DIR_CD" ).append("\n"); 
		query.append("			                                           AND     PS.VPS_PORT_CD   = Y.POD" ).append("\n"); 
		query.append("			                                           AND     PS.CLPT_IND_SEQ  = Y.CALL_IND" ).append("\n"); 
		query.append("			                                           ) THEN 1" ).append("\n"); 
		query.append("			                                     ELSE 0" ).append("\n"); 
		query.append("			                                END                    " ).append("\n"); 
		query.append("			                                           " ).append("\n"); 
		query.append("			AND      TO_NUMBER(X.ROWW)      = TO_NUMBER(Y.ROWW)" ).append("\n"); 
		query.append("			AND      TO_NUMBER(X.TIER)      < TO_NUMBER(Y.TIER)" ).append("\n"); 
		query.append("			--============================================================================================================================================" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--============================================================================================================================================" ).append("\n"); 
		query.append("      		-- Only Self BKG's Container Handling" ).append("\n"); 
		query.append("      		--============================================================================================================================================" ).append("\n"); 
		query.append("			SELECT   DISTINCT" ).append("\n"); 
		query.append("			         DECODE(Y.CNTR_TYPE,'N','D',Y.CNTR_TYPE)||DECODE(Y.CNTR_SIZE,'2','2','3','3','4','4','H','5','L','7')        						AS TPSZ" ).append("\n"); 
		query.append("			      ,  Y.ID                                                                                                        						AS CNTR" ).append("\n"); 
		query.append("			      ,  Y.FE                                                                                                        						AS FM" ).append("\n"); 
		query.append("			      ,  Y.PORT_CD                                                                                                   						AS PORT" ).append("\n"); 
		query.append("				  ,  X.POL,'*'||X.POD	AS POD" ).append("\n"); 
		query.append("			      ,  Y.BAY||Y.ROWW||Y.TIER                                                                                       						AS POSITION" ).append("\n"); 
		query.append("			      ,  DECODE(Y.CARGO_TYPE,'DG','DG',DECODE(Y.CARGO_TYPE,'RF','RF',DECODE(Y.CARGO_TYPE,'AK','AK',DECODE(Y.CARGO_TYPE,'BB','BB','DR'))))	AS CATE" ).append("\n"); 
		query.append("			      " ).append("\n"); 
		query.append("			      --,  '===================='" ).append("\n"); 
		query.append("			      --,  X.BAY,X.ROWW,X.TIER,X.SZTP_ISO,X.ID,X.POL,X.POL_ISO,X.POD,X.POD2,X.POD_ISO,X.POD2_ISO,   Y.BAY,Y.ROWW,Y.TIER,Y.SZTP_ISO,Y.ID,Y.POL,Y.POL_ISO,Y.POD,Y.POD2,Y.POD_ISO,Y.POD2_ISO" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			FROM     BAY_PLAN             X" ).append("\n"); 
		query.append("			      ,  BAY_PLAN             Y" ).append("\n"); 
		query.append("			      ,  VSK_VSL_PORT_SKD     XX" ).append("\n"); 
		query.append("			      ,  VSK_VSL_PORT_SKD     YY                   " ).append("\n"); 
		query.append("			WHERE    1 = 1" ).append("\n"); 
		query.append("			AND      X.VSL_CD             = XX.VSL_CD" ).append("\n"); 
		query.append("			AND      X.VOY_NO             = XX.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND      X.DIR_CD             = XX.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND      X.PORT_CD            = XX.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND      X.CALL_IND           = XX.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			AND      X.PLAN_TYPE          = 'F'" ).append("\n"); 
		query.append("			AND      Y.VSL_CD             = YY.VSL_CD" ).append("\n"); 
		query.append("			AND      Y.VOY_NO             = YY.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND      Y.DIR_CD             = YY.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND      Y.PORT_CD            = YY.VPS_PORT_CD" ).append("\n"); 
		query.append("			AND      Y.CALL_IND           = YY.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			AND      Y.PLAN_TYPE          = 'F'" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND      X.VSL_CD             = Y.VSL_CD" ).append("\n"); 
		query.append("			AND      X.VOY_NO             = Y.VOY_NO" ).append("\n"); 
		query.append("			AND      X.DIR_CD             = Y.DIR_CD" ).append("\n"); 
		query.append("			AND      X.PORT_CD            = Y.PORT_CD" ).append("\n"); 
		query.append("			AND      X.CALL_IND           = Y.CALL_IND" ).append("\n"); 
		query.append("			AND      X.VSL_CD             = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("			AND      X.VOY_NO             = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("			AND      X.DIR_CD             = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("			AND      XX.CLPT_SEQ          = (SELECT CLPT_SEQ FROM MAX_CLPT_SEQ)" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			--AND      X.PORT_CD            = 'CNSHA'" ).append("\n"); 
		query.append("			--AND      X.CALL_IND           = '1'" ).append("\n"); 
		query.append("			                                   " ).append("\n"); 
		query.append("			#if (${cntr_no} != '') " ).append("\n"); 
		query.append("			AND      X.ID                 IN (		--'NYKU3839440','SEGU2062320'" ).append("\n"); 
		query.append("			#foreach($key IN ${cntr_no}) " ).append("\n"); 
		query.append("				#if($velocityCount < $cntr_no.size()) " ).append("\n"); 
		query.append("					'$key', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("											)  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND      1                    = CASE WHEN TRUNC(TO_NUMBER(X.BAY)/4) <> TRUNC(TO_NUMBER(Y.BAY)/4) THEN 0                                    -- << SAME BAY >> --" ).append("\n"); 
		query.append("			                                     ELSE                                   " ).append("\n"); 
		query.append("			                                          CASE WHEN MOD(TO_NUMBER(X.BAY),2) = 0 THEN 1                                                    -- << 40 FEET + 20/40 FEET  >> --" ).append("\n"); 
		query.append("			                                               WHEN MOD(TO_NUMBER(X.BAY),2) = 1 AND MOD(TO_NUMBER(Y.BAY),2) = 0 THEN 1                    -- << 20 FEET + 40    FEET >> --" ).append("\n"); 
		query.append("			                                               WHEN MOD(TO_NUMBER(X.BAY),2) = 1 AND MOD(TO_NUMBER(Y.BAY),2) = 1 AND X.BAY = Y.BAY THEN 1  -- << 20 FEET + 20    FEET >> -- " ).append("\n"); 
		query.append("			                                               ELSE 0" ).append("\n"); 
		query.append("			                                          END                        " ).append("\n"); 
		query.append("			                                END" ).append("\n"); 
		query.append("			                          " ).append("\n"); 
		query.append("			AND      1                    = CASE WHEN (SELECT  MAX(PS.CLPT_SEQ)" ).append("\n"); 
		query.append("			                                           FROM    VSK_VSL_PORT_SKD PS " ).append("\n"); 
		query.append("			                                           WHERE   PS.VSL_CD        = X.VSL_CD" ).append("\n"); 
		query.append("			                                           AND     PS.SKD_VOY_NO    = X.VOY_NO" ).append("\n"); 
		query.append("			                                           AND     PS.SKD_DIR_CD    = X.DIR_CD" ).append("\n"); 
		query.append("			                                           AND     PS.YD_CD         = @[cod_rhnd_port_yd_cd] 	-- [rehandling terminal] --" ).append("\n"); 
		query.append("			                                           ) =" ).append("\n"); 
		query.append("			                                          (SELECT  MAX(PS.CLPT_SEQ)" ).append("\n"); 
		query.append("			                                           FROM    VSK_VSL_PORT_SKD PS " ).append("\n"); 
		query.append("			                                           WHERE   PS.VSL_CD        = Y.VSL_CD" ).append("\n"); 
		query.append("			                                           AND     PS.SKD_VOY_NO    = Y.VOY_NO" ).append("\n"); 
		query.append("			                                           AND     PS.SKD_DIR_CD    = Y.DIR_CD" ).append("\n"); 
		query.append("			                                           AND     PS.VPS_PORT_CD   = Y.POD" ).append("\n"); 
		query.append("			                                           AND     PS.CLPT_IND_SEQ  = Y.CALL_IND" ).append("\n"); 
		query.append("			                                           ) THEN 1" ).append("\n"); 
		query.append("			                                     ELSE 0" ).append("\n"); 
		query.append("			                                END                    " ).append("\n"); 
		query.append("			                                           " ).append("\n"); 
		query.append("			AND      TO_NUMBER(X.ROWW)      = TO_NUMBER(Y.ROWW)" ).append("\n"); 
		query.append("			AND      TO_NUMBER(X.TIER)      = TO_NUMBER(Y.TIER)" ).append("\n"); 
		query.append("			--============================================================================================================================================" ).append("\n"); 
		query.append("			) YY" ).append("\n"); 
		query.append("WHERE 		YY.TPSZ  = @[tpsz] 				--:cntr_tp_sz" ).append("\n"); 
		query.append("AND   		YY.FM    = @[cntr_cgo_tp_cd] 	--:fm" ).append("\n"); 
		query.append("AND   		YY.CATE  = @[cgo_cate_cd]" ).append("\n"); 

	}
}